import java.util.*;

public class HotelReservationSystem {

    public static void main(String[] args) {
        Reservation[] reserv = new Reservation[3];
        Room[] room = new Room[50];
        String resCity;
        int id = 1;
        int choice;
        Scanner sc = new Scanner(System.in);

        while(true) {       		
        	
        	for(MenuOptions rm: EnumSet.range(MenuOptions.FIRST, MenuOptions.EXIT)) {
        		System.out.printf("%-100s\n", rm.menuOptions());
        		System.out.printf("\n");
        	}        	

            choice = sc.nextInt();
            System.out.printf("\n");

            if (choice==1) {
                System.out.printf("%s\n", "Hotel Name: ");
                String hotelName = sc.next() + " " + sc.next();
                System.out.printf("%s\n", "Reservation Month: ");
                String reservationMonth = sc.next();
                System.out.printf("%s\n", "Reservation Start: ");
                int reservationStart = sc.nextInt();
                System.out.printf("%s\n", "Reservation End: ");
                int reservationEnd = sc.nextInt();               
                room[id-1] = new Room("Single");
                reserv[id-1] = new Reservation(reservationEnd, reservationStart, reservationMonth, hotelName,room[id-1]);
                System.out.printf("Reservation created!\n");
                System.out.printf("\n");
                Reservation.totalNumofReservations++;
                id++;

            }
            else if (choice==2) {
            	System.out.println("ROOM INFOS: \n");
            	for(MenuOptions rm: EnumSet.range(MenuOptions.SINGLE, MenuOptions.SUITE)) {
            		System.out.printf("%-100s\n", rm.menuOptions());
            	} 
            	System.out.printf("\n");
            	System.out.printf("%s\n", "Hotel Name: ");
            	String hotelName = sc.next() + " " + sc.next();
                System.out.printf("%s\n", "Room Type: ");
                String roomType = sc.nextLine();
                System.out.printf("%s\n", "Reservation Month: ");
                String reservationMonth = sc.next();
                System.out.printf("%s\n", "Reservation Start: ");
                int reservationStart = sc.nextInt();
                System.out.printf("%s\n", "Reservation End: ");
                int reservationEnd = sc.nextInt();
                room[id-1] = new Room(roomType);
                reserv[id-1] = new Reservation(reservationEnd, reservationStart, reservationMonth, hotelName,room[id-1]);
                System.out.printf("Reservation created!\n");
                System.out.printf("\n");
                Reservation.totalNumofReservations++;
                id++;
            }
            
            else if (choice==3) {

                for(int i=0; i<id-1; i++) {
                    System.out.println(reserv[i].displayInfo());
                    System.out.printf("\n");
                }
            }
            else if (choice==4) {
                
            	System.out.println(Reservation.totalNumofReservations + " rooms created so far.\n");
            }
            else if (choice==5) {
            	System.out.println("Type a city name for a reservation search: \n");
            	resCity=sc.next();
            	List<Reservation> list = new ArrayList<Reservation>();
            	list = Arrays.asList(reserv);
            	Iterator<Reservation> cLitr = list.iterator();
            	while (cLitr.hasNext()) {
            		Reservation reservation = cLitr.next();
            		if(reservation.getHotelName().contains(resCity)) { 
            			System.out.printf("%s \n", reservation.getHotelName());
            			
            		}
            	}
            	System.out.printf("\n");
            	
            }
            else if (choice==6) {
            	System.out.println("Type a city name for a reservation search: ");
            	resCity=sc.next();
            	List<Reservation> remList = new ArrayList<Reservation>(Arrays.asList(reserv));
            	//remList = Arrays.asList(reserv);
            	Iterator<Reservation> rRitr = remList.iterator();
            	
            	while (rRitr.hasNext()) {
            		Reservation remReservation = rRitr.next();
            		if (remReservation.getHotelName().contains(resCity)) {
            			rRitr.remove();
            			id--;
            			
            		}
            	}
            	reserv=remList.toArray(new Reservation[3]);
            	Reservation.totalNumofReservations = remList.size();
            	
            }
            else if (choice==7) {
                break;
            }
            else {
                System.out.println("Wrong choice!");
            }
        
        
        }

        sc.close();
    }

}
