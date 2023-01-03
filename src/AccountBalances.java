import java.io.*;
import java.util.*;






    /*
 * You have a map of bank account information. The key is the account name and the value is the account balance. We need to make sure each bank account has at least a balance of $X. We achieve that by transferring money from accounts with a surplus to accounts with a deficit.

   Write a method that prints the transfers we need to make to ensure all accounts are above threshold $X, if possible.

   public void transferMoney(int threshold, Map accounts)

   Example
   Account1 has $90
   Account3 has $60
   Account4 has $50
   Account2 has $140
   threshold is 100

   The method would print "Account2 sends $10 -> Account1"

   Account1 has 102
   Account2 has 99
   ACcount3 has 99


 */



    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */
    class Account {
        String name;
        Integer balance;
        public Account(String name, Integer balance) {
            this.name = name;
            this.balance = balance;
        }

    }

    class AccountBalances {

        public static void main(String[] args) {

            int threshold = 100;

            List<Account> accounts = new ArrayList<>();
            accounts.add(new Account("A", 180));
            accounts.add(new Account("B", 50));
            accounts.add(new Account("C", 130));
            accounts.add(new Account("D", 90));
            accounts.add(new Account("E", 60));
            accounts.add(new Account("F", 190));

            try{
                new AccountBalances().transferMoney(threshold, accounts);
            } catch(Exception e){

            }
        }
        public void transferMoney(int threshold, List<Account> accounts) throws Exception{
            int sum = 0;
            int total = threshold*accounts.size();
            List<Account> surpluses = new ArrayList<>();
            List<Account> deficits = new ArrayList<>();
            for(Account acc: accounts){
                total = total-acc.balance;
                if(acc.balance>threshold) {
                    surpluses.add(new Account(acc.name, (acc.balance-threshold)));
                }else {
                    deficits.add(new Account(acc.name, (threshold-acc.balance)));
                }
            }
            if(total>0){
                throw new Exception("Not enough funds");
            }
            int carryBal = 0;
            String carryAccountName = "";
            for(int i=0;i<surpluses.size();i++) {
                int surplusVal = carryBal+surpluses.get(i).balance;
                String surplusAcc = surpluses.get(i).name;
                if(carryAccountName.length()>0) {
                     surplusAcc = surpluses.get(i).name + carryAccountName;
                }


                for (int j = 0; j < deficits.size(); j++) {
                    int deficitVal = deficits.get(j).balance;
                    String deficitAcc = deficits.get(j).name;

                    if(surplusVal-deficitVal>=0) {
                        System.out.println(surplusAcc+" -> "+ deficitAcc+" transfer "+String.valueOf(deficitVal)+" carry "+(surplusVal-deficitVal));
                        //deficits.remove(j);
                        surplusVal = surplusVal-deficitVal;
                    } else if (surplusVal-deficitVal<0) {
                        carryBal = surplusVal;
                        carryAccountName = carryAccountName+surplusAcc;
                        //remove all deficits processed so far
                        deficits.subList(0, j).clear();

                        break;
                    } else if(surplusVal-deficitVal==0){
                        //deficits.remove(j);
                        carryBal = 0;
                        carryAccountName = "";
                    }
                }
            }


        }

    }

// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dropdown in the top bar.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!

