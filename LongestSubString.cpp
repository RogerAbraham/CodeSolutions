#include <string>
#include <map>
#include <iostream>
#include <vector>
using namespace std;
/*
Author: Rogers Abraham
Date: 2019/09/27
Desc: Given a string, find the length of the longest substring without repeating characters.
*/
class Solution {
public:
	int lengthOfLongestSubstring(string s) {
		int index = 0;
		string str = "";
		int maxLen = 0;
		vector<string> list;	
		char *c = &s[0];
		for (c; *c != NULL; ++c, ++index) {
			int found = str.find(*c);
			if (found == -1) {			
				str += *c;
				list.push_back(str);}
			else {				
					int p = s.find_last_of(*c,index-1);
					if ( index-p>1 ) {
						c -= (index -p)-1;
						index = p+1;
						str = *c;	
						list.push_back(str);
					}
					else {
						str = *c;
						list.push_back(str);}}}
		for (string strs : list) {
			if (strs.length() > maxLen) {
				maxLen = strs.length();}}
		return maxLen;}};
int main(){
	int res = Solution().lengthOfLongestSubstring("bpfbhmipx");
	cout << res;}