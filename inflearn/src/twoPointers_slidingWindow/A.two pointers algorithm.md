### Two Pointers Algorithm
`Two Pointers algorithm`을 활용하는 문제의 핵심은 시간 복잡도가 `O(n)`이게 풀이를 해야 한다는 것이다.
만약 Main0301문제를 O(NlogN)을 가지는 정렬로 풀이한다고 했을 때 자료가 60,000개라고 가정했을 때 960,000번을 돌아야 하지만
`Two Pointers algorithm`을 활용했을 때는 60,000번만 돌면서 시간을 효율성있게 쓸 수 있다.

<br>

아래의 두 배열을 합치는 데 적용해 보겠다.

<img width="594" alt="스크린샷 2022-10-11 오후 4 11 11" src="https://user-images.githubusercontent.com/80027033/195020130-6ccbc1cb-bc62-454c-94ed-6d73497bc7c2.png">

각각의 배열 요소를 가리키는 pointer1, pointer2가 있다. pointer1과 pointer2는 배열의 첫 요소부터 값을 비교한 후에 두 포인터 중 값이 작은 요소를 새로운 배열에 추가한다.

<img width="560" alt="스크린샷 2022-10-11 오후 4 12 55" src="https://user-images.githubusercontent.com/80027033/195020431-933d1900-279a-472c-883d-6adc8af95830.png">

pointer1의 1은 새로운 배열에 추가되었기 때문에 다음 요소를 가리키고 pointer 2는 기존의 배열 요소를 가리키면서 두 개의 값을 다시 비교하게 된다.

<img width="564" alt="스크린샷 2022-10-11 오후 4 14 40" src="https://user-images.githubusercontent.com/80027033/195020747-92900ae8-a637-4220-99b1-c8703f5b01bb.png">

<br>

그리고 끝으로 arr1의 배열 요소가 더 먼저 새로운 배열에 추가되기 때문에 pointer가 가리키는 값이 더 이상 없게 되는데 이때는 arr2의 남아있는 배열 요소들을 새로운 배열에 추가하게 된다.
