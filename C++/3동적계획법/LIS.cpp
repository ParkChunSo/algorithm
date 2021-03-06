// 최대 증가 부분 수열(LIS)
// Longest Increasing Subsequence
// 완전탐색 + 메모리제이션
// p.231

#include "stdafx.h"
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// return: sequence의 가장 긴 증가 수열의 길이를 리턴
int lis(int start);
const int MAX_LENGTH = 100;
int cache[MAX_LENGTH];
vector<int> seq;

int main()
{
	int n, tmp;
	
	scanf_s("%d", &n);
	for (int i = 0; i < n; ++i) {
		scanf_s("%d", &tmp);
		seq.push_back(tmp);
	}
	memset(cache, -1, sizeof(cache));
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

	if (start == seq.size() - 1) return 1;

	if (cache[start] != -1) return cache[start];
	
	while (index < seq.size()) {
		if (seq[start] < seq[index]) {
			maxLeng = max(1 + lis(index), maxLeng);
		}
		++index;
	}
	if (index == seq.size()) return cache[start] = maxLeng;
}
