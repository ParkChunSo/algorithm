// 피보나치 수 2
// 2748번

#include "stdafx.h"
#include <iostream>
#include <cstring>
using namespace std;

const int MAX = 90;
long long cache[MAX+1];

long long solution(int n);

int main()
{
	int n;
	scanf_s("%d", &n);
	memset(cache, -1, sizeof(cache));

	cout << solution(n) << endl;

	return 0;
}

long long solution(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;

	if (cache[n] != -1) return cache[n];
	long long& ret = cache[n];

	return ret = solution(n - 1) + solution(n - 2);
}