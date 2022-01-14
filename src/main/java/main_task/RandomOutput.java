package main_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


    public class RandomOutput {
        public void run() throws IOException {
            printMessage("Enter an integer :");
            String stringFromConsole = getStringFromConsole();

            while (!checkForValidity(stringFromConsole)) {
                printMessage("try again...:");
                stringFromConsole = getStringFromConsole();
            }

            randomPrintingOfRandomNumbers(Integer.parseInt(stringFromConsole));
        }

        private void randomPrintingOfRandomNumbers(int namber){
            Random random =new Random();

            for (int i = 0 ; i < namber; i++){
                if(random.nextBoolean()){
                    printMessage(String.format("%d ",random.nextInt(Integer.MAX_VALUE)));
                }else{
                    printMessage(String.format("\n%d ",random.nextInt(Integer.MAX_VALUE)));
                }
            }
        }

        private void printMessage(String message) {
            System.out.print(message);
        }

        private String getStringFromConsole() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        }

        private boolean checkForValidity(String string) {

            try {
                Integer.valueOf(string);
                return  true;
            }catch (NumberFormatException e){
                return false;
            }

        }

        public static void main(String[] args) throws IOException {
            new RandomOutput().run();
        }
    }


