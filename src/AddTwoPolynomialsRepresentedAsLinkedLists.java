public class AddTwoPolynomialsRepresentedAsLinkedLists {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode head = new PolyNode();
        PolyNode p = head;

        while (poly1 != null && poly2 != null) {
            if (poly1.power > poly2.power) {
                p.next = poly1;
                p = p.next;
                poly1 = poly1.next;
            } else if (poly2.power > poly1.power) {
                p.next = poly2;
                p = p.next;
                poly2 = poly2.next;
            } else {
                int newCoefficient = poly1.coefficient + poly2.coefficient;
                if (newCoefficient != 0) {
                    poly1.coefficient = newCoefficient;
                    p.next = poly1;
                    p = p.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }

        while (poly1 != null) {
            p.next = poly1;
            p = p.next;
            poly1 = poly1.next;
        }

        while (poly2 != null) {
            p.next = poly2;
            p = p.next;
            poly2 = poly2.next;
        }
        p.next = null;

        return head.next;
    }

    class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        PolyNode() {
        }

        PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }

        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x;
            this.power = y;
            this.next = next;
        }
    }
}
