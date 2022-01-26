/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.cw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author natty
 */
public class HotelCw {
    private static boolean MainMenu = true;
    private static boolean SubMenu = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         Scanner input = new Scanner(System.in);

        Room[] myHotel = new Room[8];
        myHotel[0] = new Room(); 
        myHotel[1] = new Room();
        myHotel[2] = new Room();
        myHotel[3] = new Room();
        myHotel[4] = new Room();
        myHotel[5] = new Room();
        myHotel[6] = new Room();
        myHotel[7] = new Room();
        
        String roomName;
        String Option;
        int roomNum = 0;
 
        initialise(myHotel);
        //Below is the menu options that a customer is able to choose from
         while (MainMenu) {
            while (SubMenu) {
        
         System.out.println("Hello and Welcome to our Hotel");
         System.out.println("================================================");
         System.out.println("Please look over and select one of the options.");
         System.out.println("================================================");
         System.out.println("A: Book A New Room.");
         System.out.println("================================================");
         System.out.println("V: View all Rooms.");
         System.out.println("================================================");
         System.out.println("E: Display Empty Rooms.");
         System.out.println("================================================");
         System.out.println("D: Delete customer from room.");
         System.out.println("================================================");
         System.out.println("F: Find room from customer name.");
         System.out.println("================================================");
         System.out.println("S: Store program data in to file.");
         System.out.println("================================================");
         System.out.println("L: Load program data from file.");
         System.out.println("================================================");
         System.out.println("O: View rooms Ordered alphabetically by name.");
         System.out.println("================================================");
        
         /*
         Below is the method on how users choose
         which service they want to use on the menu.
         For this method I used the if else conditions 
         */
         
         Option = input.next();
        
             if (Option.equals("A")){
                 bookARoom(myHotel, roomNum);
            }
             if (Option.equals("V")){
                 viewAllRooms(myHotel);
            }   
             if (Option.equals("E")){
                 checkIfEmpty(myHotel);
            }
                 
             if (Option.equals("D")){
                 deleteCustomerFromRoom(myHotel, roomNum);
            }     
             if (Option.equals("F")){
                 findRoomFromCustomerName(myHotel);
            }   
                 
             if (Option.equals("S")){
                 storeProgramDataInToFile(myHotel);
            }     
             if (Option.equals("L")){
                 loadProgramDataFromFile(myHotel);
            }
                 
             if (Option.equals("O")){
                 viewRoomsOrderedAlphabeticallyByName(myHotel);
            }
                 
             else{
                 System.out.println("Please choose an option from the list");
            }
                
                 
                 
         /*
          After choosing an option from the menu above    
          the program will continue, the submenu below allows the customer
          to choose another option from the main menu.  
         */              
                        
         System.out.println("================================================");
         System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
         System.out.println("================================================");
         if (input.nextInt() == 1) {
             SubMenu = true;
            } else {
             SubMenu = false;
            }
                    
         
            }
         /*
          This second submenu allows the customer to exit the program
          by pressing '2' from the first submenu and '2' again in the second
          submenu, the user will be able to exit the program           
         */
          SubMenu = true;
            System.out.println("================================================");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            System.out.println("================================================");
            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);
            }  
            }   
            }
         /*
           Below are the diffrent methods used to allow the customer
           to use the diffrent functions of the main menu
         */
    
      
    private static void initialise(Room[] myHotel) {
        /*
        This method makes sure that all rooms in the hotel are empty
        */
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("nobody");
            }
            }

    private static void bookARoom(Room[] myHotel, int roomNum) {
        /*
        This method allows the users to book a room. The program asks the user
        two questions. The room they want to book and the name for this room
        the scanner input reads what the users types in.
        */
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (0-7):");
        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();
        myHotel[roomNum].setName(roomName);
            }

    private static void viewAllRooms(Room[] myHotel) {
        /*
        This is the second option of the main menu which allows the user
        to view all rooms. 
        If a room is booked by an customer the program will print room 'x' is occupied by 'name'
        but if the room is empty the program will print room'x' is occupied by nobody.
        I used the for statement for this method.
        */
         for (int x = 0; x < myHotel.length; x++) {
             System.out.println("room " + (x + 1) + " occupied by " + myHotel[x].getName());          
            }
            }

    private static void checkIfEmpty(Room[] myHotel) {
        /*
        This method allows the user to check if there are any empty rooms.
        For this statement I used the for if statement.
        The program will print room 'x'x is empty
        */
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("nobody")) {
                System.out.println("room " + (x + 1) + " is empty");
            }
            }
            }
    
    private static void deleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        /*
        To delete an customer from the hotel program the program will ask one question,
        The room the customer is staying in. The user will be prompted to answer this qiestion.
        The scanner input will reda what the user has typed in.
        If the information is correct the program will print 'Entry Deleted'
        */
         Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(0-7):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Entry Deleted ");
            }

    private static void findRoomFromCustomerName(Room[] myHotel) {
        /*
        To find a customer in the hotel the program will ask the user for the name of the guest,
        if the name is correct the program will print 'The Account That Matches That name is Account number x'
        This method uses a scanner input to read what the user has types and a for if statement dpending on the answer given
        There is also a boolean checker 
        */
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < myHotel.length; x++) {
            if (roomName.equals(myHotel[x].getName())) {
                System.out.println("The Account That Matches That name is Account number " + x);
                Checker = true;
            }
             if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name");
            }
            }
            }
    
    private static void storeProgramDataInToFile(Room[] myHotel) throws IOException {
        /*
        This method allows the user to store the data from the program like which rooms are empty and which rooms are booked.
        using the FileWriter the data is stored in an empty file thats connected to our program.
        */
         try (PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\natty\\Documents\\Hotel Java\\Hotel cw\\src\\hotel\\cw\\Store"))) {
            int x;
            for (x = 0; x < myHotel.length; x++) {
                out.println("Name and Room number is: " + myHotel[x].getName() + "at: " + x);
            }
            }
        System.out.println("All Room Names have been Saved.");  
            }

    private static void loadProgramDataFromFile(Room[] myHotel) throws IOException {
        /*
        Instead of the using store the data from the hotel, this method allows them to load the data from the file 
        that the data was saved from
        */
          FileInputStream fs = new FileInputStream("C:\\Users\\natty\\Documents\\Hotel Java\\Hotel cw\\src\\hotel\\cw\\Store");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        for (int i = 0; i < myHotel.length; i++) {
            myHotel[i].setName(br.readLine());
            }     
            }

    private static void viewRoomsOrderedAlphabeticallyByName(Room[] myHotel) {
        /*
        When there are some customers booked into the customer this method allows the user to see all customers
        in the hotel but in alphabetical order.
        This method uses an for statement and an arrays list to put the names in order.
        */
          String[] myStrArray = new String[myHotel.length];
        for (int i = 0; i < myHotel.length; i++) {
            myStrArray[i] = myHotel[1].getName();
            }
        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
            }
            }
    
    private static class Room {   
        /*
        This class is very important to all of the methods 
        as all methods have to use the Room class to perform their functions
        */
        private String mainName;
        int guestsInRoom;
        public Room() {
             mainName = "k";
            }
          public void setName(String aName) {
            mainName = aName;
            }
           public String getName() {
            return mainName;
            }        
            } 
            }

        
     
    
    

