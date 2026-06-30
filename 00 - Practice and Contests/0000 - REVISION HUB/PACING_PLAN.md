# Pacing Plan — Classroom Knowledge → Top 1%

You already have full-course depth on Fundamentals/Math/Bits/Arrays/Searching/Matrix/Sorting/Strings/Stack-Queue/Hashing/DP (0001–0119). The gap to "top 1%" isn't more theory — it's: (1) fill Linked List/Trees/Heaps/Graphs/Backtracking/Patterns, (2) convert classroom recall into under-pressure, explain-while-coding fluency, (3) never let revised topics decay. This plan sequences that against `PROGRESS_TRACKER.md` and `GAPS_AND_ROADMAP.md`.

Assumes you're working full-time and job-hunting in parallel — budget **~1.5–2 hrs on weekdays, ~3–4 hrs on weekends.** Adjust the timeline, not the daily ritual, if your bandwidth differs.

## The daily ritual (every day, no exceptions on this part)
1. **10–15 min — Revision queue.** Open `PROGRESS_TRACKER.md`, pick the 2-3 rows with the oldest "Last Revised" / lowest confidence that are due today. Re-derive from memory, update the row.
2. **Remaining time — New material.** Either a gap topic (cheat-sheet → real problems) or fresh problems on a topic you've already covered.
3. **Last 5 min — Talk it out.** Say your approach out loud before/while coding, even alone. This is the single habit that separates "I know DSA" from "I crack interviews" — most classroom-trained engineers can code but freeze when asked to narrate their thinking live.

## Week-by-week

### Week 1 — Lock in what you already have + the easiest gap
- Revise: Sorting (0038–0044, 0118), Searching (0017–0031) — these decay fastest because they're "solved" mentally but the code details slip.
- New: Linked List (`CHEATSHEETS/LinkedList.md` → reverse, cycle detect, merge two lists, remove Nth, palindrome check). It's the smallest gap and builds confidence.
- Also: implement Merge Sort and Quick Sort by hand once (currently only scratch files) — 1 sitting each.
- Target: 8–10 problems.

### Week 2 — Trees, traversal-first
- Revise: Stack/Queue (0057–0073), Hashing (0107–0117).
- New: Trees (`CHEATSHEETS/Trees.md`) — all 3 DFS traversals, BFS/level-order, height, validate BST, LCA (both variants).
- Target: 10–12 problems. Trees take longer per problem than arrays — don't rush this week.

### Week 3 — Heaps + finish Trees
- Revise: Strings (0048–0056), DP basics (Q01–Q09).
- New: Heaps (`CHEATSHEETS/Heaps.md`) — Kth largest, top-K frequent, median of stream. Finish remaining tree problems (diameter, serialize/deserialize, invert).
- Target: 10 problems.

### Week 4 — Graphs (the biggest single gap)
- Revise: Bit Manipulation (0013–0015), DP (Q10–Q19).
- New: Graphs (`CHEATSHEETS/Graphs.md`) — BFS, DFS, number of islands (connects to your Matrix work), topo sort, Union-Find, Dijkstra. This is the heaviest week — if you only do one thing well this month, make it this.
- Target: 10–12 problems, spread over the full week.

### Week 5 — Backtracking + Patterns
- Revise: everything flagged confidence ≤3 in the tracker (should be a short list by now).
- New: Backtracking and Sliding Window/Two Pointer/Greedy/Trie from `CHEATSHEETS/Patterns.md`. These are individually small but collectively cover a large share of "clever" interview questions.
- Target: 10–12 problems.

### Week 6 onward — Mixed practice + mock interviews, on a loop
This is where "piece of cake" actually gets built — repetition under time pressure, not new content.
- 3–4 timed problems/week, **mixed random topics** (not blocked by category — real interviews don't tell you the topic in advance).
- 1 mock interview/week minimum (peer, Pramp/interviewing.io-style platform, or self-recorded explaining out loud on a timer). Specifically score yourself on: did you clarify requirements, did you state complexity before coding, did you talk while coding, did you test your own code.
- Continue the daily revision queue from the tracker indefinitely — this is what prevents the "studied it 2 months ago, blanked in the interview" failure mode.
- Every 2 weeks, do a full skim of `INDEX.md` top to bottom (10 min) just to keep the whole map fresh in your head, not just the categories you've drilled recently.

## Defining "top 1%" concretely, so you know when you're there
Not raw problem count. You're there when, for an unseen medium-difficulty problem, you can: state the brute force in under a minute, identify the optimization pattern (which `CHEATSHEETS/Patterns.md` is designed to make automatic), code it cleanly without syntax fumbling in either Java or Kotlin, state final time/space complexity unprompted, and handle "what if the input is huge / what if there are duplicates / what if it's streaming" follow-ups without panicking. Test yourself against this bar with mocks starting Week 6, not by counting how many problems you've solved.

## If you're short on time some week
Cut new-topic volume first, never cut the daily revision queue — a fading-but-broad memory of everything beats a sharp memory of half the syllabus when the interview question is random.
