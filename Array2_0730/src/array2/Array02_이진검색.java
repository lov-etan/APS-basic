package array2;

public class Array02_이진검색 {
	public static void main(String[] args) {
		
		int[] nums = {2, 4, 7, 9, 11, 19, 23};
		
		int result = binarySearch(nums, 19);
		System.out.println(result);
		
//		left =0;
//		right=7;
//		(0+7)/2 =3.5
	}
	//left -> <-right
	//left ==right // 구간 안에 마지막 데이터가 하나 존재한다는 뜻
	//그래도 못 찾으면
	// right left <- 이렇게 역전되는 경우, 멈춰야 한다 => while()
	static int binarySearch(int[] arr, int key) {
		int left =0; //구간의 시작 index
		int right = arr.length -1; //구간의 끝 index
		while(left<=right) {
			int mid = (left + right) /2; //9를 가운데로 설정//mid를 계속 바꿔서 설정해줘야 하므로 while 문 안에 존재 
			if(arr[mid] ==key) {
				return mid;
			} else if (arr[mid] < key) {
				left = mid +1;
			} else {
				right = mid -1;
			}
			
		}
		return -1;
	}

}
