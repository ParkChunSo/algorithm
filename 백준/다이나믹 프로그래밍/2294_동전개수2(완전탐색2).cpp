// 동전 개수2
// 완전탐색 + 메모리제이션 -> 시간초과

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//n: 총전 개수, k: 금액
int n, k;
const int INF = 100001;
const int MAX_SIZE = 100000;
vector<int> cents;
vector<int> cache(MAX_SIZE, 100001);

int solution2(int hap);

int main()
{
	scanf_s("%d %d", &n, &k);
	int tmp;
	for (int i = 0; i < n; ++i) {
		scanf_s("%d", &tmp);
		cents.push_back(tmp);
	}
	cout << solution2(k) << endl;
	return 0;
}

int solution2(int hap) {
	if (hap < 0) return 100001;
	else if (hap == 0) return 0;

	int& ret = cache[hap];
	if (ret != INF) return ret;

	for (int next = 0; next < cents.size(); ++next) 
		ret = min(ret, solution2(hap - cents[next]) + 1);

	return ret;
}