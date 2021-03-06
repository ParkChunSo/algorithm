// 동전 개수2
// 완전탐색 -> 시간초과

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//n: 총전 개수, k: 금액
int n, k;
// 가지고 있는 각 동전의 금액
vector<int> cents;

// 가져갈 동전
vector<int> taken;

// taken 을 가지고 있는 상태에서 
// 최소 동전개수의 개수를 리턴
int solution(int hap);

int main()
{
	scanf_s("%d %d", &n, &k);
	int tmp;
	for (int i = 0; i < n; ++i) {
		scanf_s("%d", &tmp);
		cents.push_back(tmp);
	}
	int centCnt = solution(0);
	cout << centCnt <<endl;
	return 0;
}

int solution(int hap) {
	if (hap == k) return taken.size();
	else if (hap > k) return 100001; //동전의 총합은 1000000보다 작다는 전제를 사용

	int mininum = 100000;

	for (int next = 0; next < cents.size(); ++next) {
		taken.push_back(cents[next]);
		mininum = min(mininum, solution(hap + cents[next]));
		taken.pop_back();
	}
	return mininum;
}