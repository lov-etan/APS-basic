package 수업_단방향;

public class 원형연결리스트 {
    static class Node {
        int data; // 데이터
        Node next; // 다음 노드의 참조값

        // Node의 생성자
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node last; // 마지막 노드의 참조값을 저장

        // 비어 있는 원형 연결 리스트의 생성자
        public CircularLinkedList() {
        }

        // 첫번째 노드(1개이므로 첫번째 노드 == 마지막 노드)가 주어진 경우의 생성자
        public CircularLinkedList(Node first) {
            this.last = first; // 첫번째 노드를 마지막 노드(last)로 참조
            if (this.last != null) { // 첫번째 노드가 null이 아니라면9 5
                
                this.last.next = last; // 자신의 다음을 자기 자신으로 지정
            }
        }

        public void addToEnd(int data) {
            Node n = new Node(data); // 새로운 노드 n 만들기
            if (last == null) { // 만약 리스트가 비어있다면
                n.next = n; // 자기 자신의 다음을 자기 자신으로 만들기
            } else {
                n.next = last.next; // n을 첫번째 노드와 연결
                last.next = n; // 마지막 노드와 n을 연결
            }
            last = n; // 새로운 노드 n을 마지막 노드로 만들기
        }

        public void addToStart(int data) {
            Node n = new Node(data); // 새로운 노드 n 만들기
            if (last == null) { // 만약 리스트가 비어있다면 첫번째 노드이므로
                n.next = n; // 자기 자신을 참조하도록 하고
                last = n; // 새로운 노드를 last 참조로 가리킴
            } else { // 리스트가 비어 있지 않다면 마지막 노드 다음에 새로운 노드를 추가
                n.next = last.next;
                last.next = n;
            } // 새로운 노드가 마지막 노드 뒤에 추가됐으므로, 자동으로 첫번째 노드가 된다.
        }

        public Node getNode(int target) {
            if (last != null) { // 원형 연결 리스트가 비어있지 않으면
                Node curr = last; // 임시 변수 curr를 만들고 마지막 노드로 설정
                do { // 우선 현재 노드에 대한 검사부터 수행
                    if (curr.data == target) { // 값이 일치하면
                        return curr; // 그 노드를 반환
                    } // 일치하지 않으면
                    curr = curr.next; // 검사를 먼저 수행한 후 다음 노드로 이동
                } while (curr != last); // 다음 노드로 이동했더니 마지막이면 멈춤
            }
            // 값을 찾지 못했거나 리스트가 비어 있다면
            return null; // null을 반환
        }

        public void addAfter(int target, int data) {
            Node targetNode = getNode(target); // 특정 값을 갖는 노드 찾기
            if (targetNode != null) { // 노드를 찾았다면
                Node n = new Node(data); // 새로운 노드 n 만들기
                n.next = targetNode.next; // n의 뒤 연결
                targetNode.next = n; // n의 앞 연결
            }
        }

        public Node deleteLast() {
            Node curr = last; // 임시 변수 curr 만들기
            // 만약 리스트가 비어있거나 노드가 1개뿐이라면
            if (curr == null || curr.next == null) {
                last = null; // last를 null로 만듦
                return curr; // 현재 노드를 반환
            }
            // 만약 리스트의 노드가 2개 이상이라면
            Node prev = last.next; // 임시 변수 prev를 첫번째 노드로 만듦
            while (prev.next != last) { // 다음 노드가 마지막 노드가 아니라면
                prev = prev.next; // 다음 노드로 이동
            } // prev.next가 last면(prev가 last의 직전 노드이면) 멈춤
              // while문을 빠져나오면 prev는 직전 노드를 가리킴
            Node toDelete = last; // 마지막 노드를 임시 변수에 넣음
            prev.next = last.next; // 직전 노드를 다음 노드와 연결
            last.next = null;
            last = prev; // 직전 노드가 마지막 노드가 됨
            return toDelete; // 삭제한 노드를 반환
        }

        public Node deleteStart() {
            Node firstNode = last; // 임시 변수 firstNode 생성
            // 리스트가 비어 있는 경우는 firstNode가 null
            // 리스트의 개수가 1이라면 firstNode는 last와 같음
            // 만약 리스트가 비어있거나 노드의 개수가 1개뿐이라면
            if (last == null || last.next == last) {
                last = null; // last를 null로 만들고
                return firstNode; // firstNode를 반환
            }
            firstNode = last.next; // 첫번째 노드를 저장
            last.next = firstNode.next; // 직전과 다음 노드를 연결
            firstNode.next = null; // firstNode의 다음 참조를 초기화
            return firstNode; // 저장해둔 첫번째 노드를 반환
        }

        public Node deleteAfter(int target) {
            Node targetNode = getNode(target); // 특정 값을 갖는 노드 찾기
            if (targetNode != null) { // 노드를 찾았다면
                Node toDelete = targetNode.next; // 그 다음 노드를 삭제
                // 만약 targetNode와 toDelete가 같다면 자기 자신을 참조하는 경우
                if (targetNode == toDelete) { // 이므로
                    return null; // 아무것도 하지 않음
                } else { // targetNode와 toDelete가 다르다면
                    // targetNode의 다음에 toDelete의 다음 노드 연결
                    targetNode.next = toDelete.next;
                    if (toDelete == last) // 만약 삭제한 노드가 마지막 노드라면
                        last = targetNode; // 마지막을 직전 노드로 옮김
                    toDelete.next = null; // toDelete의 참조값 초기화
                    return toDelete; // 삭제한 노드 반환
                }
            } // 노드를 찾지 못한 경우
            return null; // null을 반환
        }

        public void printList() {
            Node curr = last;
            if (curr == null) {
                System.out.println("LinkedList[]");
            } else {
                System.out.print("LinkedList[");
                curr = curr.next;
                Node first = curr;

                do {
                    System.out.print(curr.data + "->");
                    curr = curr.next;
                } while (curr != first);
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
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
        ll.deleteLast();
        ll.printList();

    }
}
