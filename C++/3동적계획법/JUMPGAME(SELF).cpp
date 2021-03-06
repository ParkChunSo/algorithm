// 외발뛰기 문제
// p.215

#include "stdafx.h"
#include <iostream>

using namespace std;
static const int MAX_X = 7, MAX_Y = 7;

//메모이제이션을 위한.
// 해당 (y,x)에서 길이 있으면 1, 없으면 0를 기억한다.(초기값은 -1)
int cache[MAX_X][MAX_Y];

int map[MAX_X][MAX_Y] = {
	{2, 5, 1, 6, 1, 4, 1},
	{6, 1, 1, 2, 2, 9, 3},
	{7, 2, 3, 2, 1, 3, 1},
	{1, 1, 3, 1, 7, 1, 2},
	{4, 1, 2, 3, 4, 1, 2},
	{3, 3, 1, 2, 3, 4, 1},
	{1, 5, 2, 9, 4, 7, -1}
};

bool jump(int y, int x);

int main()
{
	// 배열 초기화
	memset(cache, -1, sizeof(cache));
	cout << jump(0, 0) << endl;
	return 0;
}

bool jump(int y, int x) {
	if (cache[y][x] == 0)
		return false;
	else if (cache[y][x] == 1)
		return true;

	if (map[y][x] == -1)
		return true;

	int jumpSize = map[y][x];
	if (y + jumpSize < MAX_Y) {
		if (jump(y + jumpSize, x)) {
			cache[y][x] = 1;
			return true;
		}
	}
	if (x + jumpSize < MAX_X) {
		if (jump(y, x + jumpSize)) {
			cache[y][x] = 1;
			return true;
		}
	}
	cache[y][x] = 0;
	return false;
}