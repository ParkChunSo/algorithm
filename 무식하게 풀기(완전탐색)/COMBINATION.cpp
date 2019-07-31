// n개의 원소 중 m개를 고르는 모든 조합을 찾는 알고리즘.
// p.149

#include "stdafx.h"
#include <vector>
#include <iostream>

using namespace std;

void pick(int n, vector<int> & picked, int toPick);
void printPicked(vector<int> &picked);

int main()
{
	int count, n;
	printf("테스트 케이스의 횟수를 입력하세요.\n");
	scanf_s("%d", &count);
	vector<int> picked;

	for (int i = 0; i < count; i++) {
		printf("총 경우의 수를 찾아볼 N를 입력하세요.\n");
		scanf_s("%d", &n);
		pick(n, picked, 4);
	}
	
    return 0;
}

void pick(int n, vector<int> & picked, int toPick) {
	// 기저사례
	if (n < 4) { printf("적어도 4보다는 커야합니다.\n"); return; }
	if (toPick == 0) { printPicked(picked); return; }

	int smallest = picked.empty() ? 0 : picked.back() + 1;

	for (int next = smallest; next < n; next++) {
		picked.push_back(next);
		pick(n, picked, toPick -1);
		picked.pop_back();
	}
}

void printPicked(vector<int> &picked) {
	printf("(");
	for (int i = 0; i < picked.size(); i++) {
		printf(" %d", picked[i]);
	}
	printf(")");
	
}

