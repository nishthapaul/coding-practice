import sys
import math
from copy import deepcopy
from collections import defaultdict, deque
infile = sys.argv[1] if len(sys.argv)>1 else "/Users/nishthapaul/IdeaProjects/Practise/src/main/java/adventOfCode2022/inputs/day16.txt"
data = open(infile).read().strip()
lines = [x for x in data.split('\n')]

E=defaultdict(list)
R = {}
for line in lines:
    words = line.split()
    id_ = words[1]
    rate = words[4]
    nbrs = words[9:]
    rate = int(rate[5:-1])
    nbrs = [x for x in ''.join(nbrs).split(',')]
    for n in nbrs:
        E[id_].append(n)
    R[id_] = rate
#     print(id_, rate, nbrs)
to_str = {0:'AA'}
id_ = {'AA': 0}
for k in R:
    if R[k]>0 or True and k not in id_:
        id_[k]=len(id_)
        to_str[len(id_)-1] = k
N = len(id_)
E2=[[] for _ in range(N)]
for i in range(N):
    for y in E[to_str[i]]:
        SEEN = set([to_str[i]])
        dist = 1
        while y not in id_:
            dist += 1
            n1, n2 = E[y]
            assert n1 in SEEN or n2 in SEEN
            SEEN.add(y)
            y = (n2 if n1 in SEEN else n1)
        E2[i].append((dist, id_[y]))
R2 = [R[to_str[k]] for k in range(N)]
msg = 'R = vector<ll>'
msg = 'E = vector<vector<pll>>{'
for i in range(N):
    msg += '{'
    for d,y in E2[i]:
        msg += f'{{{d},{y}}},'
    msg = msg[:-1]+'},'
msg = msg[:-1]+'},'
print(msg)
# for k in R:
#     if k not in id_:
#         id_[k]=len(id_)


# print(len([o for o in R if R[o]>0]))
# print([R[i] for i in id_])
# print(E)
# assert False
# 41:49
# DP={}
# def f(pos, V, time):
#     if time == 0:
#         return 0
#     if len(DP)%1000==0:
#         print(len(DP))
#     key = (pos, tuple(sorted(V)), time)
#     if key in DP:
#         return DP[key]
#     ans = 0
#     if time>0 and pos not in V and R[pos] > 0:
#         new_V = set(V)
#         new_V.add(pos)
#         ans = max(ans, sum(R[o]for o in V)+f(pos, new_V, time-1))
#     if time>0:
#         for n in E[pos]:
#             ans = max(ans, sum(R[o]for o in V)+f(n, V, time-1))
#     DP[key] = ans
#     return ans
#
# print(f('AA', set(), 30))
# assert False
#
# ans = 0
# Q=deque([(0, 'AA', [], 30)])
# SEEN = set()
# while Q:
#     score, pos, V, time = Q.popleft()
#     if (score, pos, tuple(sorted(V)), time) in SEEN:
#         continue
#     SEEN.add((score, pos, tuple(sorted(V)), time))
#     if len(SEEN)%1000==0:
#         print(len(SEEN))
#     ans = max(ans, score)
#
#     if time>0:
#         for n in E[pos]:
#             Q.append((score+sum(R[o]for o in V), n, V, time-1))
#
# print(ans)
# print(R)
# print(E)
