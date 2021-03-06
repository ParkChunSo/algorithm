// 여행 짐 싸기
// p.269

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;
// 물건의 최대개수
const int MAX = 100;
// 입력될 물건들의 이름, 부피, 절박도를 입력
//string stuffName[MAX] = { "laptop", "camera", "xbox", "grinder", "dumbell", "encyclopedia" };
//int stuffBoo[MAX] = { 4, 2, 6, 4, 2, 10 };
//int stuffJul[MAX] = { 7, 10, 6, 7, 5, 4 };
string stuffName[MAX];
int stuffBoo[MAX];
int stuffJul[MAX];
int n, w;

int choice[MAX];

int pack(int index, int weight);

int main()
{
	int c;
	scanf_s("%d", &c);
	for (int i = 0; i < c; ++i) {
		scanf_s("%d %d", &n, &w);
		for (int j = 0; j < n; ++j)
			cin >> stuffName[j] >> stuffBoo[j] >> stuffJul[j];
		int bestChoice = 0, ret;
		for (int index = 0; index < n; ++index) {
			ret = pack(index, 0);
			if (ret > bestChoice) {
				choice[0] = index;
				bestChoice = ret;
			}
		}
		int cnt=0, weight=0;
		for (int index = 0; weight < w; ++index) {
			weight += stuffBoo[choice[index]];
			++cnt;
		}
		
		cout << bestChoice <<" "<< cnt << endl;
		for (int index = 0; index < cnt; index++) {
			cout << stuffName[choice[index]] << endl;
		}
		
	}
	return 0;
}

// index번째의 물건을 포함한 최대 절박도를 리턴
int pack(int index, int weight) {
	if (index == n-1) return stuffJul[index];

	int ret = stuffJul[index];
	int bestChoice = stuffJul[index];
	for (int next = index + 1; next < n; ++next) {
		if (weight + stuffBoo[index] + stuffBoo[next] <= w) {
			ret += pack(next, weight + stuffBoo[index]);
			if (ret > bestChoice) {
				bestChoice = ret;
				choice[index + 1] = next;
			}
			ret = stuffJul[index];
		}
	}
	return bestChoice;
}