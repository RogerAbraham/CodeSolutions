/* A Palindrome is a string with the same letters forwards and backwards.
Author: Roger Abraham
*/
#include <string>
#include <vector>
#include <iostream>

using namespace std;

class Solution {

public:

	string longestPalindrome(string s) {

		vector<string> palins;
		string orig = s, lpal = "", match(1,orig[0]);
		reverse(s.begin(), s.end());		
		size_t found=string::npos, reverseIndex = 0, convert = 0;
		int i = 0, j = 0, len = 0, biggest = 0, revlen = s.length();
		
		while (j < (revlen-biggest)) {

			len = match.size();

			if (len > biggest) {
				found = s.find(match);
			}

			if (found != std::string::npos) {

				if (len == 1 || (len == 2 && match[0] == match[1])
					|| (len == 3 && match[0] == match[2])) {

					palins.push_back(match);

					if (biggest < len) {

						biggest = len;
						lpal = match;

					}
				}

				else {

					reverseIndex = found;
					convert = (revlen - 1) - (j + (len - 1));

					if (convert == reverseIndex) {
						palins.push_back(match);
						if (biggest < len) {
							biggest = len;
							lpal = match;
						}
					}
				}
			}
			if (i == revlen - 1) {
				j++;
				i = j;
				match = orig[i];
			}
			else {
				i++;
				match += orig[i];
			}
		}
		return lpal;
	}
};

int main() {

   //string s = "aacdefcaa"; //expect aa R 100/103
	//string s = "ccd"; // expect cc : R
	//string s = "adam"; //expect ada : R
	//string s = "abacab"; //expect bacab R 
	//string s = "babadada"; // expect adada : R 50/103
	//string s = "aaabaaaa"; //expect aaabaaa : R 52/103
	//string s = "abcdasdfghjkldcba"; // expect a : R 56/103
	//string s = "babaddtattarrattatddetartrateedredividerb"; // expect: "ddtattarrattatdd"
	//string s = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir";
	//string s = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
	//string s = "cbbd"; // expect cc : R
	//string s = "abcdbbfcba";
	string ret = Solution().longestPalindrome(s);
	printf("%s", ret.c_str());

}