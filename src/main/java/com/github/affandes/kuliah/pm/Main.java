package com.github.affandes.kuliah.pm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
    public class BrowserHistory {
        private Stack<String> history; 
        private List<String> viewed;

        public BrowserHistory() {
            history = new Stack<>();
            viewed = new LinkedList<>();
        }


        public void view() {
            System.out.println("History Browser (dari yang paling baru):");
            if (viewed.isEmpty()) {
                System.out.println("Tidak ada history.");
            } else {
                for (int i = viewed.size() - 1; i >= 0; i--) {
                    System.out.println(viewed.get(i));
                }
            }
        }

      
        public void browse(String website) {
            history.push(website);
            viewed.add(website);
            System.out.println("Website '" + website + "' telah ditambahkan ke history.");
        }


        public void back() {
            if (!history.isEmpty()) {
                String lastWebsite = history.pop();
                viewed.remove(viewed.size() - 1); 
                System.out.println("Kembali dari website: " + lastWebsite);
            } else {
                System.out.println("Tidak ada website yang bisa kembali.");
            }
        }

        public static void main(String[] args) {
            BrowserHistory browserHistory = new BrowserHistory();
            Scanner scanner = new Scanner(System.in);
            String command;

            while (true) {
                System.out.println("\nPerintah: [view, browse <website>, back, exit]");
                System.out.print("Masukkan perintah: ");
                command = scanner.nextLine();

                if (command.equalsIgnoreCase("exit")) {
                    break;
                } else if (command.equalsIgnoreCase("view")) {
                    browserHistory.view();
                } else if (command.startsWith("browse ")) {
                    String website = command.substring(7); 
                    browserHistory.browse(website);
                } else if (command.equalsIgnoreCase("back")) {
                    browserHistory.back();
                } else {
                    System.out.println("Perintah tidak dikenali. Silakan coba lagi.");
                }
            }

            scanner.close();
            System.out.println("Program selesai.");
        }
    }
