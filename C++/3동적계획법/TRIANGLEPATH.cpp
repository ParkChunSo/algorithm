// 삼각형 위의 최대 경로 문제
// 완전 탐색
// p.226

#include "stdafx.h"
#include <iostream>
#include <algorithm>

using namespace std;
// 최대 크기
const int MAX_X = 100, MAX_Y = 100;
//입력받을 삼각형 모양의 매트릭스
int matrix[MAX_Y][MAX_X];
//메모리제이션 할 2차원 배열
int cache[MAX_Y][MAX_X];
//입력받을 매트릭스 크기
int n;

int path(int y, int x);

int main()
{
	//매트릭스 크기 지정
	scanf_s("%d", &n);
	int tmp = 1;
	for (int y = 0; y < n; ++y) {
		for (int x = 0; x < tmp; ++x)
			scanf_s("%d", &matrix[y][x]);
		++tmp;
	}
	//초기화
	memset(cache, -1, sizeof(cache));
	cout << "최대값: " << path(0, 0) << endl;
	return 0;
}

int path(int y, int x) {
	if (y == n - 1) return matrix[y][x];

	int& ret = cache[y][x];
	if (ret != -1) return ret;

	return ret = max(path(y + 1, x), path(y + 1, x + 1)) + matrix[y][x];
}