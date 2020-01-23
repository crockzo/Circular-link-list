import java.util.Scanner;

class ListNode{
    public int info;
    public ListNode next;
    public ListNode(int info){
        this.info = info;
    }
}
public class CircularLinkList {
    private static Scanner scan = new Scanner(System.in);
    private static ListNode START = null , LAST = null , PTR , LOCP ;
    public static int ele = 0;
        public static void main(String[] args){
            boolean flag = true;
            int choice ;
            while(flag){
                System.out.println("AVAILABLE CHOICES");
                System.out.println("1 : INSERT NODE");
                System.out.println("2 : INSERT AT FIRST POSITION");
                System.out.println("3 : INSERT AT END");
                System.out.println("4 : INSERT NODE AT PARTICULAR POSITION");
                System.out.println("5 : DELETE THE FIRST NODE");
                System.out.println("6 : DELETE THE END NODE");
                System.out.println("7 : DELETE A NODE AT A PARTICULAR POSITION");
                System.out.println("8 : FIND A NODE");
                System.out.println("9 : TRAVERSE THE LINK LIST");
                System.out.println("10 : EXIT");


                choice = scan.nextInt();

                switch(choice){
                    case 1 : insertNode();
                        break;
                    case 2 : insertFirst();
                        break;
                    case 3:  insertEnd();
                        break;
                    case 4:  insertPos();
                        break;
                    case 5:  deleteFirst();
                        break;
                    case 6 : deleteEnd();
                        break;
                    case 7:  deleteNode();
                        break;
                    case 8:  findNode();
                        break;
                    case 9: readList();
                        break;
                    case 10:
                        System.out.println("END OF CIRCULAR LINK LIST");
                        flag = false;
                        break;
                    default :
                        System.out.println("WRONG CHOICE");
                }
            }
        }


        //TO INSERT NODE IN CIRCULAR LINK LIST
    public static void insertNode(){
            if(START==null){
                System.out.print("\nENTER FIRST ELEMENT : ");
                ele = scan.nextInt();
                ListNode newNode = new ListNode(ele);
                START = newNode;
                newNode.next = START;
                LAST = newNode;
            }else{
                System.out.print("\nENTER THE ELEMENT : ");
                ele = scan.nextInt();
                ListNode newNode = new ListNode(ele);
                newNode.next = START;
                LAST.next = newNode;
                LAST = newNode;
            }
    }


    //TO INSERT THE NEW NODE AT THE FIRST POSITION OF THE CIRCULAR LINK LIST
    public static void insertFirst(){
        System.out.print("\nENTER FIRST ELEMENT : ");
        ele = scan.nextInt();
        ListNode newNode = new ListNode(ele);
        newNode.next = START;
        START = newNode;
        LAST.next = START;
    }

    //TO ADD A NEW NODE AT THE END POSITION OF THE CIRCULAR LINK LIST
    private static void insertEnd(){
        System.out.print("\nENTER THE ELEMENT : ");
        ele = scan.nextInt();
        ListNode newNode = new ListNode(ele);
        LAST.next = newNode;
        newNode.next = START;
        LAST = newNode;
    }

    //TO INSERT THE NEW NODE AT ANY PARTICULAR POSITION IN THE CIRCULAR LINK LIST
    private static void insertPos(){
        int pos , i = 1 , status = 0;
        System.out.println("ENTER POSITION : ");
        pos = scan.nextInt();
        PTR = START;
        while(i<pos){
            PTR = PTR.next;
            if(PTR==START){
                status = 1;
                break;
            }
            i++;
        }
        if(status==1){
            System.out.println("POSITION NOT FOUND");
        }else{
            System.out.print("\nENTER THE ELEMENT : ");
            ele = scan.nextInt();
            ListNode newNode = new ListNode(ele);
            newNode.next =PTR.next;
            PTR.next = newNode;
        }
    }

    //TO DELETE A NODE FROM THE STARTING OF THE CIRCULAR LINK LIST
    private static void deleteFirst(){
        System.out.println("THE DELETED NODE IS " + START.info);
            START = START.next;
            LAST.next = START;
    }

    //TO DELETE A NODE FROM THE END OF THE CIRCULAR LINK LIST
    public static void deleteEnd(){
        System.out.println("THE DELETED NODE IS " + LAST.info);
        PTR = START;
        while(PTR!=LAST){
            LOCP = PTR;
            PTR = PTR.next;
        }
        LOCP.next = START;
        LAST = LOCP;
    }

    //TO DELETE A NODE FROM ANY POSITION OF THE CIRCULAR LINK LIST
    private static void deleteNode(){
        int pos , i = 1 ;
        System.out.println("ENTER POSITION TO DELETE THAT ELEMENT : ");
        pos = scan.nextInt();
        PTR = START;
        while(PTR.next!=START && i<pos){
            LOCP = PTR;
            PTR = PTR.next;
            ++i;
        }
        if(PTR == START){
            System.out.println("POSITION NOT FOUND");
        }else{
            System.out.println("THE DELETED NODE IS " + PTR.info);
            LOCP.next = PTR.next;
        }

    }

    //TO FIND A PARTICULAR NODE IN THE CIRCULAR LINK LIST
    private static void findNode(){
        int eleFind , count = 0 , val = 0;
        int post = 0;
        System.out.println("ENTER A ELEMENT TO FIND");
        eleFind = scan.nextInt();
        PTR = START;
        while(PTR.next!=START){
            if(PTR.info==eleFind){
                count += 1;
                val = count;
                break;
            }
        }
        if(val==0){
            System.out.println("element not found".toUpperCase());
        }else{
            System.out.println("ELEMENT FOUND AT "  +val + "POSITION");
        }
    }


    //TO READ THE CIRCULAR LINK LIST
    private static void readList(){
            PTR = START;
            boolean flag = true;
            while(flag){
                System.out.print(PTR.info + "\t");
                PTR = PTR.next;
                if(PTR == START){
                    break;
                }
            }
        System.out.println("\n");
    }
}
