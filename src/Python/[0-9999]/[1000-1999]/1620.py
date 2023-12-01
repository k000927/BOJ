import sys

n, m = map(int, input().split())
pokemon_number = []
pokemon_name = []
question = []

for i in range(n):
    poke = sys.stdin.readline().strip()
    pokemon_number.append(poke)
    pokemon_name.append([poke, i + 1])

for i in range(m):
    question.append(sys.stdin.readline().strip())

pokemon_name.sort()


def binary_search(name, pokemon):
    start = 0
    end = len(pokemon) - 1
    while start <= end:
        mid = (start + end) // 2
        if pokemon[mid][0] == name:
            return pokemon[mid][1]
        elif pokemon[mid][0] > name:
            end = mid - 1
        else:
            start = mid + 1
    return


for i in range(m):
    if question[i].isdigit():
        print(pokemon_number[int(question[i]) - 1])
    else:
        print(binary_search(question[i], pokemon_name))
