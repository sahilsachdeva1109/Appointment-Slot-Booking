# Appointment-Slot-Booking
A Spring Boot project with MySQL database to manage users, slots, and appointments. This project demonstrates a full backend flow for booking, cancelling, and managing appointments with proper entity relationships, services, and RESTful APIs.

Features
	•	User Management
	•	Register users with name, email, and phone.
	•	Slot Management
	•	Create slots with date and time ranges.
	•	View all slots or only available slots.
	•	Appointment Management
	•	Book an appointment for a user with a selected slot.
	•	Cancel an appointment to free the slot.
	•	Retrieve all appointments or by ID.
	•	Relationship Handling
	•	Proper @ManyToOne relationships between User → Appointment and Slot → Appointment.
	•	Slot automatically marked as booked/free based on appointment status.
	•	Validation & Error Handling
	•	Checks for already booked slots.
	•	Ensures users and slots exist before booking.

⸻

Tech Stack
	•	Backend: Java, Spring Boot
	•	Database: MySQL
	•	JPA & Hibernate: For ORM and entity mapping
	•	REST APIs: For CRUD operations
	•	Tools: Postman (for API testing), MySQL Workbench

⸻

Database Schema
	•	users → stores user details
	•	slots → stores available time slots
	•	appointments → stores appointment bookings linking users and slots
