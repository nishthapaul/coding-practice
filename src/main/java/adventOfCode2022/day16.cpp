#include <vector>
#include <set>
#include <cassert>
#include <tuple>
#include <unordered_map>
#include <iostream>
#include <map>
#include <utility>
using namespace std;
using ll = int64_t;
using pll = pair<ll,ll>;

vector<ll> R;
vector<vector<pll> > E;

ll best = 0;
using Key = tuple<ll,ll,ll,bool>;
map<Key,ll> DP;
ll f(ll p1, ll U, ll time, bool me) {
  if(time == 0) {
    return me ? f(0,U,26,false) : 0LL;
  }

  auto key = make_tuple(p1,U,time,me);
  if(DP.count(key)==1) {
    return DP[key];
  }


  ll ans = 0;
  bool no_p1 = ((U & (1LL<<p1)) == 0);
  if(no_p1 && R[p1]>0) {
    ll newU = U | (1LL<<p1);
    assert(newU > U);
    ans = max(ans, (time-1)*R[p1] + f(p1, newU, time-1, me));
  }
  for(auto& [d,y] : E[p1]) {
    assert(d==1);
    ans = max(ans, f(y, U, time-1, me));
  }
  DP[key] = ans;
  /*if(DP.size() % 100000 == 0) {
    //cerr << DP.size() << " best=" << best << endl;
  }*/
  return ans;
}

int main() {
R = vector<ll>{0, 21, 3, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 23, 0, 0, 0, 0, 9, 0, 0, 0, 0, 19, 24, 0, 0, 0, 12, 10, 25, 4, 0, 0, 0, 0, 0, 0, 22, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 17, 0, 0, 0, 0};
E = vector<vector<pll>>{{{1,46},{1,41},{1,20},{1,25},{1,6}},{{1,5},{1,22}},{{1,12},{1,15},{1,20},{1,47},{1,53}},{{1,16},{1,24}},{{1,40},{1,35}},{{1,1},{1,24}},{{1,29},{1,0}},{{1,31},{1,28}},{{1,40},{1,55}},{{1,10},{1,50}},{{1,54},{1,9},{1,32},{1,36}},{{1,26},{1,51}},{{1,2},{1,29}},{{1,48},{1,37}},{{1,40},{1,43}},{{1,23},{1,2}},{{1,3},{1,23}},{{1,29},{1,18}},{{1,41},{1,34},{1,45},{1,39},{1,17}},{{1,31},{1,46}},{{1,2},{1,0}},{{1,40},{1,24}},{{1,23},{1,1}},{{1,33},{1,15},{1,43},{1,16},{1,22}},{{1,5},{1,21},{1,3}},{{1,52},{1,0}},{{1,50},{1,11}},{{1,29},{1,31}},{{1,44},{1,52},{1,7}},{{1,12},{1,27},{1,55},{1,17},{1,6}},{{1,35},{1,42}},{{1,7},{1,27},{1,19},{1,39},{1,53}},{{1,10},{1,38}},{{1,23},{1,48}},{{1,18},{1,47}},{{1,4},{1,30}},{{1,44},{1,10}},{{1,42},{1,13}},{{1,32}},{{1,31},{1,18}},{{1,8},{1,21},{1,14},{1,4}},{{1,18},{1,0}},{{1,30},{1,37}},{{1,14},{1,23}},{{1,36},{1,28}},{{1,50},{1,18}},{{1,0},{1,19}},{{1,2},{1,34}},{{1,33},{1,13}},{{1,54},{1,51}},{{1,9},{1,26},{1,45}},{{1,11},{1,49}},{{1,25},{1,28}},{{1,31},{1,2}},{{1,10},{1,49}},{{1,29},{1,8}}},

  //R = vector<ll>{0,13,2,20,3,0,0,22,0,21};
//E = vector<vector<pll>>{{{1,3},{1,8},{1,1}},{{1,2},{1,0}},{{1,3},{1,1}},{{1,2},{1,0},{1,4}},{{1,5},{1,3}},{{1,4},{1,6}},{{1,5},{1,7}},{{1,6}},{{1,0},{1,9}},{{1,8}}};
  //DP = vector<ll>(1e8, -1); //map<Key, ll>{};
  DP = map<Key, ll>{};
  ll p1 = f(0,0,30,false);
  ll p2 = f(0,0,26,true);
  cout << p1 << endl;
  cout << p2 << endl;
}

// g++ -o ./hello /Users/nishthapaul/IdeaProjects/Practise/src/main/java/adventOfCode2022/day16-3.cpp -std=c++17
// ./hello