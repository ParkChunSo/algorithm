// 01타일
// 1904번

#include "stdafx.h"
#include <iostream>
#include <cstring>
using namespace std;
const int MOD = 15746;

int cache[1000001];
int solution(int n);

int main()
{
	int n;
	scanf_s("%d", &n);

	memset(cache, -1, sizeof(cache));

	cout << solution(n) << endl;

	return 0;
}

int solution(int n) {
	if (n == 1) return 1;
	if (n == 2) return 2;
	if (cache[n] != -1) return cache[n];

	int& ret = cache[n];

	return ret = (solution(n - 1) + solution(n - 2)) % MOD;
}