// 원주율 외우기(PI)
// 완전탐색
// p.239

#include "stdafx.h"
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int classify(int start, int size);

string arr;

int main()
{
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; ++i) {
		cin >> arr;
		cout << min( classify(0, 3), min(classify(0, 4), classify(0, 5))) << endl;
	}
		
	return 0;
}

int classify(int start, int size) {
	if (start == arr.size()) return 0;
	
	if ((start + size - 1) > arr.size()) return 100;

	string M = arr.substr(start, size);

	//모든 숫자가 같을 때
	if (M == string(size, M[0]))
		return min( classify(start + size, 3), min(classify(start + size, 4), classify(start + size, 5) )) + 1;

	//숫자가 1씩 단조 증가하거나 단조 감소 할 때
	bool progressive = true;
	for (int i = 1; i < M.size(); ++i) {
		if (M[i] - M[i - 1] != M[1] - M[0])
			progressive = false;
	}
	if(progressive && abs(M[1] - M[0]) == 1)
		return min(classify(start + size, 3), min(classify(start + size, 4), classify(start + size, 5))) + 2;

	//두 개의 숫자가 번갈아가며 나타날 때
	bool alternating = true;
	for (int i = 0; i < M.size(); ++i) {
		if (M[i] != M[i % 2] && i != 1)
			alternating = false;
	}
	if(alternating)
		return min(classify(start + size, 3), min(classify(start + size, 4), classify(start + size, 5))) + 4;

	//숫자가 등차 수열을 이룰 때
	if(progressive)
		return min(classify(start + size, 3), min(classify(start + size, 4), classify(start + size, 5))) + 5;

	return min(classify(start + size, 3), min(classify(start + size, 4), classify(start + size, 5))) + 10;
}