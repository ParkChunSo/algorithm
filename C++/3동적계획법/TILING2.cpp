// 타일링 방법의 수 세기(TILING2)
// p.252

#include "stdafx.h"
#include <iostream>
#include <algorithm>

using namespace std;

int cache[101];
//n의 최대값이 100이므로 mod연산을 통해 값을 뽑아야함.
const int MOD = 1000000007;

int tiling(int n);

int main()
{
	int n;
	scanf_s("%d", &n);

	memset(cache, -1, sizeof(cache));
	cache[1] = 1;
	cache[2] = 2;
	cout << tiling(n) << endl;

	return 0;
}

int tiling(int n) {
	int& ret = cache[n];
	if (ret != -1) return ret;

	return ret = (tiling(n - 1) + tiling(n - 2)) % MOD;
}