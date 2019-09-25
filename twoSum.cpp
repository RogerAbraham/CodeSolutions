#include<vector>
#include <string>
#include <iostream>
#include <chrono>
#include <unordered_map>
using namespace std;

class Solution {

public:
	vector<int> bruteTwoSum(vector<int>& nums, int target) {
		//Find what two numbers in the array add up to target. assume 1 solution, and each integer used once
		int cur = 0;
		int rdr = 0;
		int pos1 = 0;
		int pos1val = 0;
		vector<int> sol;

		for (int i = 0; i < nums.size(); i++) {
			cur = nums.at(i);
			rdr = target - cur;
			pos1 = i;
			pos1val = nums.at(pos1);

			for (int j = pos1 + 1; j < nums.size(); j++) {
				cur = nums.at(j);
				if (pos1val + cur == target) {

					sol = { pos1, j };
					return sol;
				}
			}
		}

		return sol;
	}
	vector<int> hashTwoSum(vector<int>& nums, int target) {

		unordered_map<int, int> map;
		unordered_map<int, int>::iterator it;
		for (int i = 0; i < nums.size(); i++) {
			int complement = target - nums[i];
			if ((it = map.find(complement)) != map.end()) {
				vector<int> ret;
				ret.push_back(i);
				ret.push_back(it->second);
				return ret;
			}
			map.insert(make_pair(nums[i], i));
		}
		vector<int> ret;
		ret.insert(ret.begin(), 2, 0);
		return ret;
	}
};

vector<int> createTestArray() {

	srand(time(NULL));
	int size = rand() % (rand() % 1000 + 1) + 1; //Random num ber between 1- (rand(1-1000))
	vector<int> nums;

	for (int i = 0; i < size; i++) {

		int val = rand() % 2001 + (-1000);
		nums.push_back(val);

	}
	return nums;

}
vector<long long> execPerf() {

	// this shuld measure the exec time of the passed in fucntion with the passed in params
	//execute about 1000 times and ge the average values
	vector<long long> times;
	vector<int> ret;

	long long count1 = 0.0;
	long long count2 = 0.0;


	//cout << "Generated array of random values: " << integerVectorToString(test);
	//cout << "Chosen target value is: " << target;
	for (int i = 0; i < 1000; i++) {

		//RANDOM ARRAY AND RANDOM TARGET ROUTINE START
		vector<int> test = createTestArray();
		srand(time(NULL));
		int rIval1 = (rand() % test.size());
		int rIval2 = (rand() % test.size());
		while (rIval1 == rIval2) {
			rIval1 = (rand() % test.size());
		}
		int target = test.at(rIval1) + test.at(rIval2);
		//RANDOM ARRAY AND RANDOM TARGET ROUTINE END

		auto t3 = chrono::high_resolution_clock::now();
		ret = Solution().hashTwoSum(test, target);
		auto t4 = chrono::high_resolution_clock::now();
		auto d2 = chrono::duration_cast<chrono::microseconds>(t4 - t3).count();
		count2 += d2;

		auto t1 = chrono::high_resolution_clock::now();
		ret = Solution().bruteTwoSum(test, target);
		auto t2 = chrono::high_resolution_clock::now();
		auto d1 = chrono::duration_cast<chrono::microseconds>(t2 - t1).count();
		count1 += d1;
		//TIMING FUNCTION EXECUTION END
	}

	return times={ count1, count2 };
}

int main() {

	vector<long long> times = execPerf();

	cout<< "BruteForce Result: " <<(times.at(0)/1000.000)  << " mics"<< endl;
	cout << "HashMap Result: " << (times.at(1) / 1000.000) << " mics"<< endl;

}