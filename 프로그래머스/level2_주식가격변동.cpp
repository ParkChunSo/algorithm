// 주식가격 떨어지지 않는 구간 구하기
// 프로그래머스 level 2

#include "stdafx.h"
#include <iostream>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
	vector<int> answer;
	int sec;
	for (int i = 0; i <prices.size(); ++i) {
		for (int tmp = i + 1; tmp < prices.size(); ++tmp) {
			++sec;
			if (prices[i] > prices[tmp])
				break;
		}
		answer.push_back(sec);
		sec = 0;
	}
	return answer;
}