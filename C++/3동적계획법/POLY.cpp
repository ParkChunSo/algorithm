// 폴리오미노
// p.266

#include "stdafx.h"
#include <iostream>

using namespace std;
//첫 줄이 first개이며 n - first개의 정사각형으로 만들 수 있는 폴리오미노의 개수
int poly(int n, int first);

int MOD = 10000000;
int cache[101][101];

int main()
{
	int c, n;
	scanf_s("%d", &c);
	for (int i = 0; i < c; ++i) {
		scanf_s("%d", &n);
		memset(cache, -1, sizeof(cache));
		int total = 0;
 		for (int j = 1; j <= n; ++j) 
			total += poly(n, j);
		cout << total <<endl;
		
	}
	return 0;
}

// n개의 정사각형으로 만드는 폴리오미노의 개수를 리턴
// 하지만 바로 윗 줄의 접하는 정사각형의 개수의 영향을 받기 때문에 
// 바로 윗줄의 정사각형이 몇개인지도 같이 인수로 보냄
// first: 첫 줄의 정사각형의 개수
// n : 남아있는 정사각형의 개수
int poly(int n, int first) {
	// 기저사례
	if (n == first) return 1;

	int& ret = cache[n][first];
	if (ret != -1)
		return ret;
	ret = 0;
	for (int second = 1; second <= n - first; ++second) {
		int add = first + second - 1;
		add *= poly(n - first, second);
		add %= MOD; // 오버플로우 방지
		ret += add;
		ret %= MOD; // 오버플로우 방지
	}

	return ret;
}