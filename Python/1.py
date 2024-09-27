age = input("Input your age = ")

if int(age) >= 18:
    print("You are an adult")
    print("You can vote")
elif 18 > int(age) > 3:
    print("You are in school")
else:
    print("You are a chjld")
