// 이항계수 계산하기
// p.195

#include "stdafx.h"
#include <iostream>

using namespace std;

int bino(int n, int r);
int cache[30][30] = {0, };

int main()
{
	int count;
	printf("테스트 케이스의 횟수를 입력하세요.\n");
	scanf_s("%d", &count);

	for (int i = 0; i < count; i++) {
		int n, r;
		scanf_s("%d %d", &n, &r);
		cout << bino(n, r) << endl;
	}
	return 0;
}

int bino(int n, int r) {
	//기저사례
	if (n == r || r == 1) return 1;
	if (cache[n][r] != 0) return cache[n][r];
	return cache[n][r] = bino(n - 1, r - 1) + bino(n - 1, r);

}