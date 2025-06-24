# Approach:
# - Use a dictionary to track the last timestamp when each message was printed.
# - For each new (timestamp, message):
#     - If the message hasn't been seen before, it's allowed.
#     - If it has been seen, check the time gap:
#         - If current_timestamp - last_timestamp[message] >= 10 → allow and update timestamp
#         - Else → reject

# Time Complexity: O(1) per call
# Space Complexity: O(n), where n is the number of unique messages seen so far


class Logger:
    def __init__(self):
        self.last_printed = {}

    def couldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.last_printed:
            self.last_printed[message] = timestamp
            return True
        if timestamp - self.last_printed[message] >= 10:
            self.last_printed[message] = timestamp
            return True
        return False

def main():
    test_cases = [
        [[1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]],
        [[1, "foo"], [1, "bar"], [1, "bar"], [11, "foo"], [11, "bar"]]
    ]

    print("🔍 Logger Rate Limiter — Test Outputs")
    for i, inputs in enumerate(test_cases, 1):
        logger = Logger()
        print(f"\nTest Case {i}:")
        for timestamp, message in inputs:
            result = logger.couldPrintMessage(timestamp, message)
            print(f"Input: [{timestamp}, \"{message}\"] → Output: {result}")
        print("-" * 40)


if __name__ == "__main__":
    main()
