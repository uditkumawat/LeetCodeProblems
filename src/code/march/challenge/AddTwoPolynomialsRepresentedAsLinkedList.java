package code.march.challenge;

//https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists/
//TC- O(m+n)
public class AddTwoPolynomialsRepresentedAsLinkedList {

    static class PolyNode {
      int coefficient, power;
      PolyNode next = null;

      PolyNode() {}
      PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
      PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
  }

  public static void main(String args[]){

        PolyNode p1 = new PolyNode(2,2);
        p1.next = new PolyNode(4,1);
        p1.next.next = new PolyNode(3,0);

      PolyNode p2 = new PolyNode(3,2);
      p2.next = new PolyNode(-4,1);
      p2.next.next = new PolyNode(-1,0);

      AddTwoPolynomialsRepresentedAsLinkedList obj = new AddTwoPolynomialsRepresentedAsLinkedList();
      PolyNode list = obj.addPoly(p1,p2);

      while(list!=null){
          System.out.println(list.coefficient+" "+list.power+" ");
          list = list.next;
      }

  }

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {

        PolyNode dummy = new PolyNode();
        PolyNode temp = dummy;

        while(poly1!=null && poly2!=null){

            if(poly1.power==poly2.power){
                int sum = poly1.coefficient+poly2.coefficient;
                if(sum!=0){
                    temp.next = new PolyNode(sum,poly1.power);
                    temp = temp.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
            else if(poly1.power<poly2.power){
                temp.next = new PolyNode(poly2.coefficient,poly2.power);
                poly2 = poly2.next;
                temp = temp.next;
            }
            else{
                temp.next = new PolyNode(poly1.coefficient,poly1.power);
                poly1 = poly1.next;
                temp = temp.next;
            }
        }

        while(poly1!=null){
            temp.next = new PolyNode(poly1.coefficient,poly1.power);
            temp = temp.next;
            poly1 = poly1.next;
        }


        while(poly2!=null){
            temp.next = new PolyNode(poly2.coefficient,poly2.power);
            temp = temp.next;
            poly2 = poly2.next;
        }

        return dummy.next;
    }
}
