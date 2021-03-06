// 울타리 잘라내기
// p.195

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solve(int left, int right);

vector<int> h;

int main()
{
	int count;
	printf("테스트 케이스의 횟수를 입력하세요.\n");
	scanf_s("%d", &count);

	for (int i = 0; i < count; i++) {
		int size = 0;
		scanf_s("%d", &size);
		//int *arr = new int[size];	//동적 할당해주는 법.=
		int tmp;
		for (int j = 0; j < size; j++) {
			scanf_s("%d", &tmp);
			h.push_back(tmp);
		}
		cout << solve(0, h.size() - 1) << endl;
		h.clear();
	}
	return 0;
}

int solve(int left, int right) {
	//기저사례
	if (left == right)
		return h[left];

	int mid = (left + right) / 2;
	int ret = max(solve(left, mid), solve(mid + 1, right));
	int lo = mid, hi = mid + 1;
	int height = min(h[lo], h[hi]);
	// 가운데 겹친 부분
	ret = max(ret, height * 2);
	while (lo > left || hi < right) {
		// 더 높이가 높은 부분을 먼저(중요함)
		if (lo > left && (hi == right || h[lo - 1] > h[hi + 1])) {
			--lo;
			height = min(h[lo], height);
		}
		else {
			++hi;
			height = min(h[hi], height);
		}
		ret = max(ret, (hi - lo + 1) * height);
	}
	return ret;
}
