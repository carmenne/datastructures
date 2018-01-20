import time

#First implementation: checking off
def anagram_checkOff(s1, s2):
    s1_list = list(s1)
    index = 0
    stillSearch = True # stop searching if an element was not found
    index2 = 0
    result = False
    found = False
    
    while stillSearch and index < len(s1):
        while not found and index2 < len(s2):
            if s1[index] == s2[index2]:
                found = True
                result = True
            else:
                result = False
                stillSearch = False
            index2 = index2 + 1
        index = index + 1
                
    return result

def anagram_sort(s1, s2):
    s1_sorted = sorted(list(s1))
    s2_sorted = sorted(list(s2))
    
    return s1_sorted == s2_sorted
    
    
def anagram_count(s1, s2):
    count1 = [0]*26
    count2 = [0]*26
    
   
    for s in s1:
        count1[ord(s) - ord('a')] += 1
        
    for s in s2:
        count2[ord(s) - ord('a')] += 1
        
    return count1 == count2

start = time.time()
res = anagram_checkOff('abcd','dcba')
end = time.time()
print("Anagram sorted: %s in %f " %(res,
end - start))

start = time.time()
res = anagram_sort('abcd','dcba')
end = time.time()
print("Anagram sorted: %s in %f " %(res,
end - start))

start = time.time()
res = anagram_count('abcd','dcba')
end = time.time()
print("Anagram sorted: %s in %f " %(res,
end - start))
