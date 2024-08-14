package 수업_양방향;

public class 구현코드2 {
    static class Node {
        int data; // 데이터
        Node prev; // 이전 노드의 참조값
        Node next; // 다음 노드의 참조값

        // 노드의 생성자
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList {
        Node head; // 가장 첫번째 노드에 대한 참조값

        // 비어 있는 연결리스트 생성
        public DoublyLinkedList() {

        }

        // head가 주어지는 경우
        public DoublyLinkedList(Node head) {
            this.head = head; // 첫번째 노드가 주어진다면 그 노드를 head로 가리킴
        }

        public void addToEnd(int data) {
            Node n = new Node(data); // 새로운 노드 n 생성
            if (head == null) // 만약 리스트가 비어있다면
                head = n; // 새로운 노드 n이 첫번째 노드가 됨
            else { // 리스트가 비어 있지 않다면
                Node curr = head; // 임시 변수 curr 생성
                while (curr.next != null) { // 다음 노드가 있다면
                    curr = curr.next; // 다음 노드로 이동
                } // while문을 빠져나오면 curr는 가장 마지막 노드를 가리킴
                curr.next = n; // 가장 마지막의 다음에 새로운 노드 n 연결
                n.prev = curr; // 새로운 노드 n의 직전에 curr 연결
            }
        }

        public void addToStart(int data) {
            Node n = new Node(data); // 새로운 노드 n 생성
            if (head == null) { // 만약 리스트가 비어 있다면
                head = n; // 새로운 노드 n이 첫번째 노드가 됨
            } else { // 리스트가 비어 있지 않다면
                n.next = head; // n의 뒤에 head를 연결
                head.prev = n; // head의 앞에 n을 연결
                head = n; // head 포인터를 n으로 이동
            }
        }

        public Node getNode(int target) {
            Node curr = head; // 임시 변수 curr 생성
            while (curr != null) { // curr가 null이 아니라면
                if (curr.data == target) // 우리가 찾는 값이라면
                    return curr; // 해당 노드를 반환
                curr = curr.next; // 그렇지 않으면 다음 노드로 넘어감
            }
            return null; // 못찾은 경우 null을 반환
        }

        public void addAfter(int target, int data) {
            Node targetNode = getNode(target); // 특정 값을 갖는 노드 찾기
            if (targetNode != null) { // 노드를 찾았다면
                Node n = new Node(data); // 새로운 노드 n 생성
                // n과 targetNode.next를 먼저 연결(뒷부분)
                n.next = targetNode.next;
                targetNode.next.prev = n;
                // targetNode와 n을 연결(앞부분)
                targetNode.next = n;
                n.prev = targetNode;
            }
        }

        public Node deleteLast() {
            Node curr = head; // 임시 변수 curr 생성
            // 만약 리스트가 비어있거나, 원소가 1개 뿐이라면
            if (curr == null || curr.next == null) {
                head = null; // head를 null로 만들고
                return curr; // curr를 반환
            }
            // 리스트의 원소가 2개 이상이고
            while (curr.next != null) { // 그 다음 노드가 있다면
                curr = curr.next; // 다음 노드로 이동
            } // while문을 빠져나오면 curr는 마지막 노드를 가리킨다
            Node toDelete = curr; // 마지막 노드를 반환하기 위해 임시 저장
            // 마지막 노드와 직전 노드 연결 끊기
            curr.prev.next = null; // 직전 노드의 next를 null로 만듦
            curr.prev = null; // 마지막 노드의 prev를 null로 만듦
            return toDelete; // 마지막 노드 반환
        }

        public Node deleteStart() {
            Node toDelete = head; // 첫번째 노드를 임시 변수 toDelete에 저장
            // 만약 리스트가 비어있거나 리스트의 원소가 1개 뿐이라면
            if (head == null || head.next == null) {
                head = null; // head를 null로 만들고
                return toDelete; // toDelete를 반환
            }
            head = head.next; // head 옮기기(두번째 노드가 head가 됨)
            // 두 노드 사이의 연결 끊기
            head.prev.next = null; // 첫번째 노드의 다음 참조값을 null로 만듦
            head.prev = null; // 두번째 노드의 직전 참조값을 null로 만듦
            return toDelete; // 삭제한 원소 반환하기
        }

        public Node deleteAfter(int target) {
            Node targetNode = getNode(target); // targetNode 찾기
            Node toDelete = null; // toDelete 임시 변수 만들기
            if (targetNode != null) // 만약 targetNode를 찾았다면
                toDelete = targetNode.next; // 그 다음 노드를 저장

            if (toDelete != null) { // 삭제할 노드가 있고
                if (toDelete.next != null) { // 삭제할 노드의 다음도 있다면
                    // 삭제할 노드의 다음 노드의 prev에 targetNode를 넣음
                    toDelete.next.prev = targetNode;
                } // 삭제할 노드가 마지막 노드라면 toDelete.next는 null
                  // targetNode의 next가 toDelete.next를 가리키도록 함
                targetNode.next = toDelete.next;
            }
            return toDelete; // 삭제한 노드를 반환
        }

        public void printList() {
            Node curr = head;

            System.out.print("LinkedList[");

            while (curr != null) {
                System.out.print(curr.data + "->");
                curr = curr.next;
            }

            System.out.println("]");

            Node lastNode = getLastNode();
            if (lastNode != null) {
                System.out.print("Reversed  [");
                while (lastNode != null) {
                    System.out.print(lastNode.data + "->");
                    lastNode = lastNode.prev;
                }
                System.out.println("]");
            }
        }

        public Node getLastNode() {
            Node curr = head;
            if (head == null)
                return null;

            while (curr.next != null) {
                curr = curr.next;
            }
            return curr;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList(null);
        ll.printList();
        ll.addToStart(1);
        ll.printList();
        ll.addToStart(2);
        ll.printList();
        ll.addToEnd(3);
        ll.printList();
        ll.addToStart(4);
        ll.printList();
        ll.addAfter(1, 5);
        ll.printList();
        ll.deleteAfter(2);
        ll.printList();
        ll.deleteStart();
        ll.printList();
        ll.deleteLast();
        ll.printList();
    }
}