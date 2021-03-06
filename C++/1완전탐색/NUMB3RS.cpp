// 두니발 박사의 탈옥
// p.269

#include "stdafx.h"
#include <iostream>
#include <vector>
using namespace std;
const int MAX = 50;
// 마을이 연결되어 있는 상황을 기억
int matrix[MAX][MAX];
int connected[MAX];
//n: 마을 수, d: 일, 
//p: 교도소가 있는 마을 번호, t: 확률을 계산할 마을의 수
int n, d , p, t;

double search(vector<int> path, int q);

int main()
{
	int c;
	scanf_s("%d", &c);
	for (int i = 0; i < c; ++i) {
		scanf_s("%d %d %d", &n, &d, &p);
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) 
				scanf_s("%d", &matrix[y][x]);
		}
		scanf_s("%d", &t);
		vector<int> q;
		int tmp;
		for (int j = 0; j < t; ++j) {
			scanf_s("%d", &tmp);
			q.push_back(tmp);
		}
		for (int j = 0; j < n; ++j) {
			for (int k = 0; k < n; ++k) 
				connected[j] += matrix[j][k];
		}
		
		for (int j = 0; j < t; ++j) {
			vector<int> path;
			path.push_back(p);
			double tmp = search(path, q[j]);
			cout << tmp << endl;;
		}

		memset(matrix, 0, sizeof(matrix));
		memset(connected, 0, sizeof(connected));
	}
	return 0;
}

double search(vector<int> path, int q) {
	double ret = 0.0;
	if (path.size() == d + 1) {
		if (path.back() != q)
			return 0;
		ret = 1.0;
		for (int i = 0; i < d; ++i) 
			ret /= connected[path[i]];

		return ret;
	}

	for (int i = 0; i < n; ++i) {
		if (matrix[path.back()][i]) {
			path.push_back(i);
			ret += search(path, q);
			path.pop_back();
		}
	}
	return ret;
}

