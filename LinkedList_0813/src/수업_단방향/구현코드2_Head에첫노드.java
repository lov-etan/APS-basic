package 수업_단방향;

public class 구현코드2_Head에첫노드 {
    static class Node {
        int data; // 데이터
        Node next; // 다음 노드의 참조값

        // Node의 생성자
        // 데이터를 받아서 Node를 생성
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // 비어 있는 연결 리스트 생성
        public SinglyLinkedList() {
        }

        // head가 주어지는 경우
        public SinglyLinkedList(Node head) {
            this.head = head; // 첫번째 노드가 주어진다면 그 노드를 head로 가리킴
        }

        public void addToEnd(int data) {
            Node n = new Node(data); // 새로운 노드 생성
            if (head == null) // 만약 리스트가 비어있다면
                head = n; // 새로운 노드를 head로 가리킴
            else { // 만약 리스트가 비어있지 않다면 가장 마지막 노드를 찾는다.
                Node curr = head; // 임시 변수 curr에 첫번째 노드를 담음
                while (curr.next != null) { // 다음 노드가 있다면
                    curr = curr.next; // 다음 노드로 이동
                }
                // while문을 빠져나오면 curr는 가장 마지막 노드를 가리킴
                curr.next = n; // 새로운 노드를 가장 마지막 노드 뒤에 추가
            }
        }

        public void addToStart(int data) {
            Node n = new Node(data); // 새로운 노드 생성
            n.next = head; // 새로운 노드의 next를 기존의 첫번째 노드를 가리키도록 함
            head = n; // 새로운 노드를 첫번째 노드로 만듦
        }

        public Node getNode(int target) {
            Node curr = head; // 임시 변수 curr에 첫번째 노드를 담음
            while (curr != null) { // 만약 curr가 null이 아니라면
                if (curr.data == target) // 데이터가 우리가 찾는 값인지 비교
                    return curr; // 우리가 찾는 값이면 그 노드를 반환
                curr = curr.next; // 그렇지 않으면 다음 노드로 넘어감
            }
            return null; // 값을 찾지 못했으면 null을 반환
        }

        // target 값을 갖는 노드 다음에 data 값을 갖는 노드를 추가
        public void addAfter(int target, int data) {
            Node targetNode = getNode(target); // 특정 값을 갖는 노드 찾기
            if (targetNode != null) { // 노드를 찾았다면
                Node n = new Node(data); // 새로운 노드 생성
                n.next = targetNode.next; // n의 뒤 연결
                targetNode.next = n; // n의 앞 연결
            }
        }

        public Node deleteLast() {
            Node curr = head; // 임시 변수 curr에 첫번째 노드를 담음
            // 리스트가 비어있거나 1개만 있는 경우
            if (curr == null || curr.next == null) {
                head = null; // head를 null로 하고
                return curr; // curr를 반환
            }
            // 리스트가 2개 이상인 경우
            // curr의 다음 노드를 저장할 nextNode 변수 생성
            Node nextNode = curr.next;
            while (curr.next != null) {
                if (nextNode.next == null) { // nextNode가 마지막
                                             // 노드이면
                    curr.next = null; // curr.next에 null을 집어 넣음
                } // nextNode가 마지막 노드가 아니면
                curr = nextNode; // curr을 그 다음 노드로
                nextNode = nextNode.next; // nextNode를 그 다음 노드로
            }
            return nextNode; // 삭제한 nextNode를 반환
        }

        public Node deleteStart() {
            if (head != null) { // 만약 리스트가 비어있지 않다면
                Node toDelete = head; // 첫번째 노드를 임시 저장
                head = head.next; // head가 다음 노드를 가리키도록 함
                return toDelete; // 첫번째 노드 반환
            } // 리스트가 비어 있다면
            return null; // null을 반환
        }

        public Node deleteAfter(int target) {
            // targetNode 찾기
            Node targetNode = getNode(target);
            Node toDelete = null;

            if (targetNode != null) // targetNode를 찾았다면
                toDelete = targetNode.next;

            // targetNode의 다음 노드가 있다면
            if (toDelete != null) {
                // targetNode.next가 toDelete.next를 가리키도록 함
                targetNode.next = toDelete.next;
            }

            return toDelete; // 삭제한 노드를 반환
        }

        public void printList() {
            Node curr = head;
            System.out.print("LinkedList[head:");

            while (curr != null) {
                System.out.print(curr.data + "->");
                curr = curr.next;
            }
            System.out.println("]");
        }

    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(0);
        System.out.println(n1);
        System.out.println(n2);

        SinglyLinkedList ll = new SinglyLinkedList();
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