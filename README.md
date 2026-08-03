 # 🚨 AI Disaster Response Management System

A Java-based intelligent disaster response management system designed to analyze emergency situations and automatically allocate rescue teams, resources, and shelter capacity based on disaster severity and requirements.

The project demonstrates practical implementation of **Java OOP, Collections, Streams, Exception Handling, Input Validation, and a Rule-Based AI Decision Engine**.

---

## 📌 Project Overview

During a disaster, emergency teams need to quickly determine:

- How serious is the emergency?
- Which rescue team should be deployed?
- Which resources are required?
- How many people need shelter?
- Is sufficient shelter capacity available?

This system automates these decisions using a **rule-based AI allocation engine**.

The application accepts emergency information from the user, analyzes the situation, calculates a priority score, and automatically allocates appropriate teams, resources, and shelter.

---

## ✨ Key Features

- 🚨 Disaster severity analysis
- 🤖 Rule-based AI decision engine
- 👨‍🚒 Automatic rescue team allocation
- 📦 Disaster-specific resource allocation
- 🏠 Shelter capacity management
- 📊 Priority score calculation
- 🔎 Critical request filtering using Java Streams
- 📚 Collection-based emergency request management
- ⚠️ Custom exception handling
- ✅ User input validation
- 🌊 Flood response
- 🔥 Fire response
- 🏚️ Earthquake response
- 🔄 Dynamic system state updates

---

## 🧠 AI Decision Engine

The project uses a **rule-based AI decision engine** rather than a machine-learning model.

The engine analyzes emergency parameters such as:

- Disaster type
- Severity
- People affected
- Injured people

Based on these values, the system determines:

```text
Emergency Request
        ↓
AI Analysis
        ↓
Priority Score
        ↓
Priority Level
        ↓
Rescue Team Selection
        ↓
Resource Allocation
        ↓
Shelter Allocation
        ↓
Response Result
