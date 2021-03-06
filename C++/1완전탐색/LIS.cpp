// 최대 증가 부분 수열(LIS)
// Longest Increasing Subsequence
// 완전탐색
// p.231

#include "stdafx.h"
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// return: sequence의 가장 긴 증가 수열의 길이를 리턴
int lis(int start);

vector<int> seq;

int main()
{
	int n, tmp;
	
	scanf_s("%d", &n);
	for (int i = 0; i < n; ++i) {
		scanf_s("%d", &tmp);
		seq.push_back(tmp);
	}
	int maxLength = 0;
	for (int i = 0; i < seq.size(); ++i) {
		maxLength = max(maxLength, lis(i));
	}

	cout << "최대 증가 수열의 길이는 " << maxLength << "입니다." << endl;
		
	return 0;
}

int lis(int start) {
	int index = start + 1;
	int maxLeng = 1;
	int tmp;

	if (start == seq.size() - 1) return 1;
	
	while (index < seq.size()) {
		if (seq[start] < seq[index]) {
			maxLeng = max(1 + lis(index), maxLeng);
		}
		++index;
	}
	if (index == seq.size()) return maxLeng;
}
