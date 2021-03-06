// 카카오 코딩테스트
// 오픈채팅방

#include "stdafx.h"
#include <vector>
#include <string>
#include <utility>
#include <map>

using namespace std;

map<string, string> users;
//0: 들어옴, 1: 나감
vector<pair<int, string>> logs;

vector<string> solution(vector<string> record) {
	vector<string> answer;
	for (string data : record) {
		string tmp;
		vector<string> tmpList;
		for (int index = 0; index < data.size(); ++index) {
			tmp += data[index];
			if (data[index] == ' ' || index == data.size() - 1) {
				if (tmp.back() == ' ')
					tmp.pop_back();
				tmpList.push_back(tmp);
				tmp.clear();
			}
		}
		if (tmpList[0] == "Enter") {
			users[tmpList[1]] = tmpList[2];
			logs.push_back(pair<int, string>(0, tmpList[1]));
		}
		else if (tmpList[0] == "Leave") 
			logs.push_back(pair<int, string>(1, tmpList[1]));
		
		else if (tmpList[0] == "Change") 
			users[tmpList[1]] = tmpList[2];
	}
	
	for (int index = 0; index < logs.size(); ++index) {
		pair<int, string> log = logs[index];
		string tmpString = "";
		tmpString = users[log.second];
		if (log.first == 0)
			tmpString += "님이 들어왔습니다.";
		else
			tmpString += "님이 나갔습니다.";
		answer.push_back(tmpString);
	}
	return answer;
}
int main()
{
	vector<string> record;
	record.push_back("Enter uid1234 Muzi");
	record.push_back("Enter uid4567 Prodo");
	record.push_back("Leave uid1234");
	record.push_back("Enter uid1234 Prodo");
	record.push_back("Change uid4567 Ryan");

	solution(record);

	return 0;
}

