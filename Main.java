import java.util.*;

public class Main
{
    
    public static void bookTicket(Passenger p)
    {
        TicketBooker booker = new TicketBooker();
        if(TicketBooker.availableWaitingList == 0)
        {
            System.out.println("No Tickets Available");
            return;
        }
        if((p.berthPreference.equals("L") && TicketBooker.availableLowerBerths > 0 )||
           (p.berthPreference.equals("M") && TicketBooker.availableMiddleBerths > 0) ||
           (p.berthPreference.equals("U") && TicketBooker.availableUpperBerths > 0))
        {
            System.out.println("Preferred Berth Available");
            if(p.berthPreference.equals("L"))
            {
                System.out.println("Lower Berth Given");
                booker.bookTicket(p,(TicketBooker.lowerBerthsPositions.get(0)),"L");
                TicketBooker.lowerBerthsPositions.remove(0);
                TicketBooker.availableLowerBerths--;
            }
            else if(p.berthPreference.equals("M"))
            {
                System.out.println("Middle Berth Given");
                booker.bookTicket(p,(TicketBooker.middleBerthsPositions.get(0)),"M");
                TicketBooker.middleBerthsPositions.remove(0);
                TicketBooker.availableMiddleBerths--;

            }
            else if(p.berthPreference.equals("U"))
            {
                System.out.println("Upper Berth Given");
                booker.bookTicket(p,(TicketBooker.upperBerthsPositions.get(0)),"U");
                TicketBooker.upperBerthsPositions.remove(0);
                TicketBooker.availableUpperBerths--;
            }

        }       
        else if(TicketBooker.availableLowerBerths > 0)
        {
            System.out.println("Lower Berth Given");
            booker.bookTicket(p,(TicketBooker.lowerBerthsPositions.get(0)),"L");
            TicketBooker.lowerBerthsPositions.remove(0);
            TicketBooker.availableLowerBerths--;
            

        }
        else if(TicketBooker.availableMiddleBerths > 0)
        {
            System.out.println("Middle Berth Given");
            booker.bookTicket(p,(TicketBooker.middleBerthsPositions.get(0)),"M");
            TicketBooker.middleBerthsPositions.remove(0);
            TicketBooker.availableMiddleBerths--;

        }
        else if(TicketBooker.availableUpperBerths > 0)
        {
            System.out.println("Upper Berth Given");
            booker.bookTicket(p,(TicketBooker.upperBerthsPositions.get(0)),"U");
            TicketBooker.upperBerthsPositions.remove(0);
            TicketBooker.availableUpperBerths--;
            
        }
        else if(TicketBooker.availableRacTickets > 0)
        {
            System.out.println("RAC available");
            booker.addToRAC(p,(TicketBooker.racPositions.get(0)),"RAC" );
        }
        else if(TicketBooker.availableWaitingList > 0)
        {
            System.out.println("Added to Waiting List");
            booker.addToWaitingList(p,(TicketBooker.waitingListPositions.get(0)),"WL");
            
        }
        
    }
    public static void cancelTicket(int id)
    {
        TicketBooker booker = new TicketBooker();
        if(!booker.passengers.containsKey(id))
        {
            System.out.println("Passenger detail Unknown");
        }
        else
            booker.cancelTicket(id);
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while(loop)
        {
            System.out.println(" 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Tickets \n 4. Booked Tickets \n 5. Exit");
            int choice = s.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter Passenger name,age and berth preference (L,M or U)");
                    String name = s.next();
                    int age = s.nextInt();
                    String berthPreference = s.next();
                    Passenger p = new Passenger(name,age,berthPreference);
                    bookTicket(p);
                }
                break;
                case 2:
                {
                    System.out.println("Enter passenger Id to cancel");
                    int id = s.nextInt();
                    cancelTicket(id);
                }
                break;
                case 3:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printAvailable();
                }
                break;
                case 4:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printPassengers();
                }
                break;
                case 5:
                {
                    loop = false;
                }
                break;
                default:
                break;
            }
        }
    }
}