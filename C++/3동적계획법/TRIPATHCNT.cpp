// 삼각형 위의 최대 경로 개수 세기(TRIPATHCNT)
// p.254

#include "stdafx.h"
#include <iostream>
#include <algorithm>

using namespace std;

// y, x에서 가질 수 있는 최대값 리턴
int path(int y, int x);
// y, x에서 가질 수 있는 최대 경로의 수 리턴
int count(int y, int x);

int answer[10] = { 9, 5, 7, 1, 3, 2, 3, 5, 5, 6 };

int countCache[100][100];
int cache[100][100];
int triangle[100][100];
int n;

int main()
{
	int tmp = 0, index = 1;
	scanf_s("%d", &n);

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < index; ++j) 
			scanf_s("%d", &triangle[i][j]);
		++index;
	}

	memset(cache, -1, sizeof(cache));
	memset(countCache, -1, sizeof(countCache));

	cout << "최대 경로의 합   : " << path(0, 0) << endl;
	cout << "최대 경로의 개수 : " << count(0, 0) << endl;
	return 0;
}
int path(int y, int x) {
	int& ret = cache[y][x];

	if (y == n - 1) 
		return ret = triangle[y][x];

	if (ret != -1) return ret;

	return ret = max(path(y + 1, x), path(y + 1, x + 1)) + triangle[y][x];
}

int count(int y, int x) {
	int& ret = countCache[y][x];

	if (y == n - 1) return ret = 1;

	if (ret != -1) return ret;

	if (cache[y + 1][x] > cache[y + 1][x + 1])
		return ret = count(y + 1, x);
	else if (cache[y + 1][x] < cache[y + 1][x + 1])
		return ret = count(y + 1, x + 1);
	else {
		return ret = count(y + 1, x) + count(y + 1, x + 1);
	}
}