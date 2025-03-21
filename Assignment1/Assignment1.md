```mermaid

flowchart TD
    A[Start] --> B[Create Scanner Object]
    B --> C[Print "Please enter your year:"]
    C --> D[Read input as string (yearStr)]
    D --> E{Is yearStr a valid 4-digit year?}
    E -->|Yes| F[Convert yearStr to integer (year)]
    E -->|No| G[Print "Invalid year format. Please enter a valid 4-digit year."]
    F --> H{Is year a leap year?}
    H -->|Yes| I[Print "year is a leap year"]
    H -->|No| J[Print "year is NOT a leap year"]
    G --> K[End]
    I --> K
    J --> K

```
