package com.mhmdhsyni.fitnesspro // MUST match the Manifest and Activities

// NOTE: This file relies on the data classes defined in DataClasses.kt (BaseFitnessItem, FitnessItem, FoodItem, BodybuilderProfile).

object FitnessData {

    // A list for the Exercise Sub-Categories (REQUIRED FOR NAVIGATION)
    val exerciseCategories = listOf(
        FitnessItem("Chest", "Muscle Group", "Workouts focusing on Pectorals."),
        FitnessItem("Back", "Muscle Group", "Workouts focusing on Lats and Trapezius."),
        FitnessItem("Shoulders", "Muscle Group", "Workouts focusing on Deltoids."),
        FitnessItem("Legs", "Muscle Group", "Workouts focusing on Quads, Hams, and Calves."),
        FitnessItem("Arms", "Muscle Group", "Workouts focusing on Biceps and Triceps."),
        FitnessItem("Core", "Muscle Group", "Workouts focusing on Abs and Obliques.")
    )


    // =========================================================================
    // 1. EXERCISE DATA (Expanded and COMPLETE - 90 total moves)
    // =========================================================================
    val exercisesList = listOf(
        // --- CHEST (15 items) ---
        FitnessItem(
            "Barbell Bench Press (Flat)",
            "Chest",
            "**SETUP:** Lie on a flat bench with your eyes under the bar. Arch your back slightly, pushing your chest up while squeezing your shoulder blades back and down. Plant your feet flat on the floor.\n\n**EXECUTION:** Grip the bar slightly wider than shoulder-width. Unrack the bar by extending your arms and moving it over your shoulders. Lower the bar slowly to your mid-chest while tucking your elbows in (about 45–75 degrees from your torso). Touch the chest lightly, then press the bar back up explosively to the starting position. Lock your elbows at the top and keep your butt on the bench.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Incline Dumbbell Press",
            "Chest",
            "**SETUP:** Set a bench to a 30-45 degree angle. Sit down and plant your feet firmly. Bring the dumbbells up to shoulder height, palms facing forward.\n\n**EXECUTION:** Press the dumbbells upward and slightly inward until your arms are fully extended over your shoulders. Lower the dumbbells slowly and under control, getting a deep stretch in the upper chest. Focus on a controlled path; this angle emphasizes the upper pectoral muscles.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Weighted Chest Dip",
            "Chest",
            "**SETUP:** Use parallel bars, strapping on weight if necessary. Grip the bars firmly and push yourself up to the starting position with locked elbows.\n\n**EXECUTION:** Lean your torso forward about 30 degrees (this recruits the chest more than triceps). Lower your body slowly until your shoulder joint is below your elbow. Ensure elbows flare out slightly. Drive back up by squeezing your chest muscles. Go slow on the descent and achieve a deep stretch.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Cable Crossover (High-to-Low)",
            "Chest",
            "**SETUP:** Set two high pulleys on a cable machine. Grab the handles and step forward, taking a staggered stance. Keep a slight bend in your elbows.\n\n**EXECUTION:** Bring the handles down and across your body in a sweeping motion, squeezing your pectoral muscles hard at the center. Visualize shaking hands and hold the contraction for one full second before returning to the starting position under control. The high-to-low angle targets the lower chest fibers.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Dumbbell Fly (Flat)",
            "Chest",
            "**SETUP:** Lie on a flat bench, holding dumbbells directly over your chest with palms facing each other. Maintain a slight, fixed bend in your elbow (locked angle) throughout the movement.\n\n**EXECUTION:** Lower the dumbbells out and away from your body in a wide arc until you feel a deep stretch in your chest. Stop before the shoulder joint feels stressed. Bring the dumbbells back up using only the chest muscles. This exercise is best for stretching and isolation; use light to moderate weight for high reps.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Dumbbell Bench Press (Flat)",
            "Chest",
            "Similar to barbell, but allows for deeper stretch and rotational freedom. Keep wrists straight and elbows tucked 45-75 degrees.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Smith Machine Bench Press",
            "Chest",
            "Fixed bar path allows for maximum isolation and less stabilizer work. Good for heavy presses or working around shoulder issues. Use moderate weight.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Machine Chest Press",
            "Chest",
            "Excellent for high-rep warm-ups or drop sets. Focus on controlling the negative (return) phase and achieving peak contraction.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Push-Ups (Weighted/Decline)",
            "Chest",
            "Classic bodyweight movement. Place weight on your back or elevate your feet (decline) to increase difficulty and target the upper chest.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Slight Decline Barbell Press",
            "Chest",
            "Using a slight decline (15 degrees) helps recruit the lower chest fibers and is often easier on the shoulders than the flat bench.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Cable Crossover (Mid-level)",
            "Chest",
            "Set the pulleys to chest height. Pull the handles straight across your body. This targets the central fibers of the pectoralis muscle, focusing on thickness.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Pec Deck Fly (Machine)",
            "Chest",
            "Isolation machine where you push pads together. Provides constant tension and is excellent for pre-exhaustion or finishing the chest routine.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Kneeling Cable Press",
            "Chest",
            "Kneel in front of a cable machine set high. Press the handle forward (like a standing cable fly but kneeling). Excellent for core stability and chest contraction.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Landmine Press",
            "Chest",
            "Use a barbell anchored in a corner. Press the end of the bar forward/upward. Excellent alternative for people with shoulder pain, hitting the upper chest and core stability.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Barbell Guillotine Press",
            "Chest",
            "Perform a flat bench press, but lower the bar very high on the chest (near the neck). Use light weight! This puts extreme tension on the upper chest but is high-risk for the shoulders.",
            R.drawable.ic_exercise_placeholder
        ),

        // --- BACK (15 items) ---
        FitnessItem(
            "Deadlift (Conventional)",
            "Back",
            "**SETUP:** Stand with your mid-foot under the barbell. Grip the bar just outside your shins (shoulder-width grip). Bend your knees until your shins touch the bar. Lift your chest and brace your core, keeping your back straight/neutral.\n\n**EXECUTION:** Take a big breath, hold it, and stand up with the weight by driving your feet through the floor. The bar should stay in contact with your legs the entire time. Do not shrug or lean back at the top; simply lock your hips and knees into a fully upright position. To lower, push your hips back first until the bar passes your knees, then bend your legs to set the bar down to a dead stop.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Barbell Row (Yates Style)",
            "Back",
            "**SETUP:** Stand with feet shoulder-width apart. Hinge forward at the hips, maintaining a 45-degree angle to the floor (torso should be closer to vertical than parallel). Use an underhand (supinated) grip.\n\n**EXECUTION:** Row the bar towards your lower stomach/hips, focusing on pulling with the elbows and squeezing the shoulder blades together. Control the negative back to the starting position. This style emphasizes the lats and lower traps.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Lat Pulldown (Wide Grip)",
            "Back",
            "**SETUP:** Sit down and secure your knees under the pads. Grab the wide bar with an overhand grip, slightly wider than shoulder width. Lean back slightly (10-15 degrees).\n\n**EXECUTION:** Pull the bar straight down to your upper chest/collarbone, focusing on depressing the shoulders and engaging the lats (lats are responsible for pulling your elbows down). Slowly return the bar up, allowing for a full stretch in the lats at the top.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "T-Bar Row (Handle)",
            "Back",
            "**SETUP:** Place your feet on the platforms, hinge forward, and place your chest against the pad (if applicable). Use the close-grip handle.\n\n**EXECUTION:** Row the handles back towards your abdomen while keeping elbows tucked in close to the body. Focus on keeping the chest against the pad and initiating the pull with the back muscles, not just the arms. Control the weight back down for a deep stretch.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Seated Cable Row (Wide Grip)",
            "Back",
            "**SETUP:** Sit at the machine with legs slightly bent, feet on the platform. Use a wide bar attachment (overhand grip). Maintain an upright posture.\n\n**EXECUTION:** Pull the bar towards your lower chest, retracting your shoulder blades fully. Avoid excessive rocking or momentum. Focus on stretching the lats and middle back at the start and squeezing the upper back hard at the finish.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Pull-Ups (Wide Overhand Grip)",
            "Back",
            "Bodyweight exercise for width. Focus on pulling your collarbone to the bar. Initiate the movement by depressing the shoulders, pulling elbows down and back.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Chin-Ups (Underhand Grip)",
            "Back",
            "Bodyweight exercise that heavily recruits the lats and biceps. Use a shoulder-width underhand grip.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Single-Arm Dumbbell Row",
            "Back",
            "Place one knee/hand on a bench. Row the dumbbell up towards your hip, twisting your torso slightly at the top for peak contraction. Excellent for fixing imbalances and a deep stretch.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Straight Arm Cable Pulldown",
            "Back",
            "Isolation move for the lats. Use a straight bar on a high pulley. Keep arms straight and pull the bar down to your thighs. Excellent for feeling the lat connection.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Machine Pullover",
            "Back",
            "Focuses purely on lat stretch and contraction. Use the dedicated machine or a straight bar attachment over a bench. Control the movement and breathe deeply.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Hyperextension (Back Extension)",
            "Back",
            "Targets the lower back (erector spinae) and glutes. Lie face down on the machine, hinge at the hips, and extend until your body forms a straight line. Hold a plate for added resistance.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Reverse Grip Barbell Row",
            "Back",
            "Uses an underhand grip, which often allows for a slightly greater range of motion and emphasizes the upper lats and biceps.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "V-Bar Pulldown (Close Neutral Grip)",
            "Back",
            "Uses a V-handle attachment. This grip is often shoulder-friendly and targets the lower lats for thickness.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Rack Pulls",
            "Back",
            "A partial deadlift performed from safety pins/blocks. Used to overload the upper and middle back, often beneficial for improving lockout strength.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Chest-Supported Dumbbell Row",
            "Back",
            "Lying face-down on an incline bench removes the need for stabilizing the lower back, allowing for maximum focus on the mid and upper back muscles.",
            R.drawable.ic_exercise_placeholder
        ),

        // --- SHOULDERS (15 items) ---
        FitnessItem(
            "Overhead Press (Standing Barbell)",
            "Shoulders",
            "**SETUP:** Stand with the barbell resting on your front deltoids. Brace your core and glutes hard.\n\n**EXECUTION:** Press the barbell straight overhead until your arms are locked out. As the bar passes your head, press your head forward slightly to align your body directly under the bar. Control the weight back down to the collarbone position.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Dumbbell Lateral Raise",
            "Shoulders",
            "**SETUP:** Hold light dumbbells at your sides. Maintain a slight, fixed bend in your elbow.\n\n**EXECUTION:** Raise your arms out to the sides until they are parallel to the floor, leading with the elbow. Think about pouring water out of a jug (slight internal rotation). This isolates the medial (side) deltoid head.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Seated Dumbbell Press",
            "Shoulders",
            "**SETUP:** Sit upright on a bench with back support. Bring dumbbells to shoulder level.\n\n**EXECUTION:** Press the dumbbells up, moving them slightly inward, until your arms are fully locked out overhead. Great for high volume work as it removes the stability required for standing.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Reverse Pec Deck Fly",
            "Shoulders",
            "**SETUP:** Sit facing the machine, placing your chest against the pad.\n\n**EXECUTION:** Focus on moving your arms backward, squeezing the rear shoulder heads (posterior deltoids) together. Essential for shoulder health.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Face Pull",
            "Shoulders",
            "**SETUP:** Use a rope attachment on a cable machine set at head height.\n\n**EXECUTION:** Pull the rope towards your face, separating the hands and externally rotating your shoulders at the end. Targets the rear deltoids and upper back stabilizers.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Arnold Press (Seated)",
            "Shoulders",
            "A variation of the dumbbell press where you start palms facing you and rotate to palms facing forward as you press up. Hits all three deltoid heads.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Front Raise (Plate/Dumbbell)",
            "Shoulders",
            "Isolation for the front deltoids. Raise a plate or dumbbells straight out in front of you to shoulder height. Keep movement controlled and slow.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "High Cable Row (Rear Delt Focus)",
            "Shoulders",
            "Set the cable low. Pull a rope attachment toward your face, focusing on externally rotating the shoulders and keeping elbows high.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Band Pull Apart",
            "Shoulders",
            "Shoulder health and warm-up exercise. Hold a resistance band and pull your hands apart, squeezing your rear delts and mid-back at the end.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Shrugs (Barbell/Dumbbell)",
            "Shoulders",
            "Targets the Trapezius muscles. Hold heavy weight and simply raise your shoulders toward your ears (shrug). Control the descent.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Dumbbell Upright Row",
            "Shoulders",
            "Pulls dumbbells straight up towards the chin. Targets traps and medial deltoids. Ensure elbows stay higher than wrists to avoid impingement.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Single-Arm Cable Lateral Raise",
            "Shoulders",
            "Uses a low cable pulley. Allows for continuous tension throughout the entire range of motion, providing a great isolation pump for the side delts.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Machine Shoulder Press",
            "Shoulders",
            "Seated machine press offers stability and a fixed path, ideal for training heavy or focusing purely on muscle failure without worrying about balance.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Power Cleans (Light Weight)",
            "Shoulders",
            "Olympic lift variation that focuses on explosive trap and shoulder movement. Use light weight for high velocity.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Leaning Cable Lateral Raise",
            "Shoulders",
            "Hold onto a post and lean away from the cable machine. This change in body angle allows the side deltoid to stay under tension for a greater part of the movement.",
            R.drawable.ic_exercise_placeholder
        ),

        // --- LEGS (15 items) ---
        FitnessItem(
            "Barbell Back Squat (High Bar)",
            "Legs",
            "**SETUP:** Place the bar across your upper back. Brace your core and drive your knees out in line with your toes.\n\n**EXECUTION:** Squat down until your hips are parallel to your knees or slightly below. Drive through your mid-foot to stand back up, keeping your chest up and your back straight.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Leg Press (Machine)",
            "Legs",
            "**SETUP:** Sit in the machine and place your feet shoulder-width apart on the sled.\n\n**EXECUTION:** Press the sled away, stopping just before your knees lock out. Control the negative fully. Foot placement dictates quad vs. hamstring/glute focus.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Romanian Deadlift (RDL)",
            "Legs",
            "**SETUP:** Stand tall, holding a barbell or dumbbells. Start with knees slightly bent; maintain this bend.\n\n**EXECUTION:** Hinge at the hips, pushing your hips backward until you feel a deep stretch in the hamstrings. Squeeze your glutes and hamstrings to return to the standing position.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Bulgarian Split Squat",
            "Legs",
            "**SETUP:** Place one foot back on a bench. Hold dumbbells at your sides.\n\n**EXECUTION:** Descend straight down, ensuring the front knee tracks over the middle of the front foot. Drive through the heel of the front foot to stand back up. Focus on stability and deep stretch.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Leg Extension",
            "Legs",
            "**SETUP:** Sit in the machine and adjust the pad to rest just above your ankles.\n\n**EXECUTION:** Extend your legs fully, pausing and squeezing the quadriceps hard at the top. Slowly lower the weight stack back down. Isolation for quads.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Barbell Front Squat",
            "Legs",
            "Bar is held across the front of the shoulders. Requires more core stability and places greater emphasis on the quadriceps and upper back. Use a slightly narrower stance than back squat.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Lying Leg Curl (Machine)",
            "Legs",
            "Hamstring isolation. Lie face down and curl the weight up towards your glutes. Focus on peak contraction at the top. Great for hamstring thickness.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Seated Calf Raise",
            "Legs",
            "Machine where you sit down and raise the weight with your knees bent. Specifically targets the soleus muscle, crucial for overall calf development.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Hack Squat (Machine)",
            "Legs",
            "Machine that uses a fixed angle, reducing lower back strain. Foot placement can be varied to target quads (low feet) or glutes/hams (high feet).",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Walking Lunges (Dumbbells)",
            "Legs",
            "Excellent for dynamic leg strength, balance, and unilateral development. Take long strides to hit glutes/hams, or shorter strides to focus on quads.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Glute Ham Raise (GHR)",
            "Legs",
            "Advanced bodyweight movement that intensely targets both hamstrings and glutes through simultaneous hip and knee flexion/extension. Use a GHR machine.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Standing Barbell Calf Raise",
            "Legs",
            "Targets the gastrocnemius muscle (the visible 'ball' of the calf). Stand with the balls of your feet on a block and perform slow, deep raises.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Belt Squat (Machine)",
            "Legs",
            "Uses a belt to load the weight directly through the hips, completely removing spinal compression. Excellent for high-volume leg training.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Sissy Squat (Machine/Hack)",
            "Legs",
            "Highly aggressive quad isolation move. Focuses tension entirely on the quadriceps by leaning back and flexing the knees forward. Use machine or hold onto support.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Pistol Squat (Assisted)",
            "Legs",
            "Advanced unilateral bodyweight squat. Squat on one leg while the other is extended. Use a suspension strap or handle for assistance.",
            R.drawable.ic_exercise_placeholder
        ),

        // --- ARMS (15 items) ---
        FitnessItem(
            "Barbell Bicep Curl (Straight Bar)",
            "Arms",
            "**SETUP:** Stand straight, holding a straight bar with an underhand grip. Keep elbows pinned tightly to your sides.\n\n**EXECUTION:** Curl the bar up towards your chest. Avoid swinging your body; focus on slow, controlled movement. Control the negative.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Dumbbell Hammer Curl",
            "Arms",
            "**SETUP:** Stand holding dumbbells at your sides with palms facing your body (neutral grip).\n\n**EXECUTION:** Curl the dumbbells up without rotating your wrists. Excellent for forearm development (brachialis/brachioradialis) and elbow health.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Skullcrusher (Lying Triceps Extension)",
            "Arms",
            "**SETUP:** Lie on a flat bench, holding a bar over your chest. Keep elbows pointing forward.\n\n**EXECUTION:** Lower the weight towards your forehead by bending only at the elbows. Extend the arms fully, flexing the triceps at the top. Be gentle with the weight.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Tricep Pushdown (Rope)",
            "Arms",
            "**SETUP:** Use a rope on a high pulley. Pin your elbows tightly to your sides.\n\n**EXECUTION:** Push the rope down, separating your hands at the bottom for a maximal triceps squeeze. Control the negative back up to the starting position.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Preacher Curl (Barbell/Dumbbell)",
            "Arms",
            "**SETUP:** Sit at the preacher bench, resting your upper arms on the pad.\n\n**EXECUTION:** Lower the weight until your arms are fully extended. Curl the weight up, focusing purely on the bicep contraction. The bench isolates the biceps.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Close-Grip Bench Press",
            "Arms",
            "Pressing with a narrower grip than standard bench press. This heavily recruits the triceps (specifically the long head) while still hitting the chest.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Concentration Curl",
            "Arms",
            "Sit down and brace your elbow against the inside of your thigh. Curl the dumbbell with extreme focus and slow speed. Excellent for achieving a peak contraction and mind-muscle connection.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Cable Curl (Standing)",
            "Arms",
            "Using a low cable pulley provides constant tension throughout the range of motion, unlike free weights where tension drops at the top/bottom.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Overhead Dumbbell Triceps Extension",
            "Arms",
            "Using one or two dumbbells overhead. Stretches the long head of the triceps maximally, which is crucial for overall arm size.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Reverse Curl (EZ Bar)",
            "Arms",
            "Uses an overhand (pronated) grip on the barbell. Targets the brachialis and brachioradialis (forearms) heavily, aiding overall arm thickness.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Triceps Kickback (Dumbbell)",
            "Arms",
            "Bend forward and extend a dumbbell backward. Requires strict form, maintaining the upper arm parallel to the floor, to focus on the contraction of the triceps.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Spider Curl (Incline Bench)",
            "Arms",
            "Lie chest-down on an incline bench. Curl dumbbells or an EZ-bar. The angle removes any possibility of cheating and maximizes biceps isolation.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Triceps Dip (Bench)",
            "Arms",
            "Use a bench or parallel bars. Keep your body upright (no forward lean) and elbows tucked to focus the movement on the triceps. Can be weighted.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Zottman Curl",
            "Arms",
            "Bicep curl with a supinated grip on the way up, followed by a pronated grip on the way down. Hits biceps and forearms/brachialis strongly.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Wrist Curls (Barbell/Dumbbell)",
            "Arms",
            "Sits with forearms on your knees and curls the weight with the wrist only. Isolation for the wrist flexors (forearms).",
            R.drawable.ic_exercise_placeholder
        ),

        // --- CORE (15 items) ---
        FitnessItem(
            "Plank (Forearm)",
            "Core",
            "**SETUP:** Drop down onto your forearms, ensuring elbows are beneath your shoulders. Your body should form a straight line.\n\n**EXECUTION:** Brace your abdominal muscles and glutes hard. Hold this isometric position for the desired duration.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Hanging Leg Raise",
            "Core",
            "**SETUP:** Hang from a pull-up bar.\n\n**EXECUTION:** Engage your core and raise your legs until your hips are bent 90 degrees or higher. Focus on posterior pelvic tilt (tucking the hips under) to maximize lower abdominal activation.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Ab Wheel Rollout",
            "Core",
            "**SETUP:** Start on your knees, holding the ab wheel beneath your shoulders.\n\n**EXECUTION:** Slowly roll the wheel out. Contract your abs powerfully to pull the wheel back to the starting position. Requires intense core bracing.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Cable Crunch",
            "Core",
            "**SETUP:** Kneel beneath a high pulley, holding a rope near your neck.\n\n**EXECUTION:** Crunch your torso downwards, pulling with your abs to bring your elbows towards your hips. Round your back slightly for peak contraction.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Russian Twist (Weighted)",
            "Core",
            "**SETUP:** Sit on the floor with knees bent, holding a weight plate. Maintain a slight lean back.\n\n**EXECUTION:** Rotate your torso side-to-side, tapping the weight on the floor beside your hips on each side. Targets the oblique muscles.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "V-Up (Floor)",
            "Core",
            "Lying on your back, simultaneously raise your straight legs and your torso/arms to meet in a 'V' shape. Targets upper and lower abs simultaneously.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Side Plank (Weighted)",
            "Core",
            "Isometric hold performed on your side (on one elbow). Excellent for oblique and deep core stability. Can add weight to the top hip.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Toes-to-Bar",
            "Core",
            "Advanced version of the hanging leg raise where you aim to touch your toes to the pull-up bar. Requires powerful hip flexion and abdominal strength.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Landmine Twist (Standing)",
            "Core",
            "Hold the end of a landmine-anchored barbell and rotate the weight from side-to-side, keeping your arms straight. Dynamic oblique training.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Hanging Windshield Wiper",
            "Core",
            "Advanced hanging exercise. Raise straight legs to the bar, then swing them side-to-side like a windshield wiper blade. Excellent for rotational core power.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Reverse Crunch (Bench)",
            "Core",
            "Lying on a bench, hold the top edge. Pull your knees toward your chest, tucking your pelvis under to hit the lower abs. Focus on pelvic tilt, not hip flexors.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Decline Sit-Up (Weighted)",
            "Core",
            "Sit-up performed on a decline bench. Can hold a weight plate behind the head or against the chest. Allows for a greater range of motion and stretch.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Woodchopper (Cable)",
            "Core",
            "Use a high cable pulley. Grab the handle and pull it diagonally down and across your body, twisting the torso forcefully. Targets obliques.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "L-Sit (Parallel Bar/Floor)",
            "Core",
            "An isometric hold where you support your body weight on your hands (on parallel bars or the floor) with your legs straight out in front, forming an L shape.",
            R.drawable.ic_exercise_placeholder
        ),
        FitnessItem(
            "Bicycle Crunch",
            "Core",
            "Lie on your back, hands behind your head. Bring opposite elbow to opposite knee while extending the other leg. Focus on the slow, controlled twist.",
            R.drawable.ic_exercise_placeholder
        ) // <-- This is the final item, NO comma here.
    ) // End of exercisesList


    // =========================================================================
    // HELPER FUNCTIONS (REQUIRED BY DetailActivity and ListActivity)
    // =========================================================================

    /**
     * Searches all lists for an item matching the given title.
     * Required by DetailActivity to display content.
     */
    fun getDetailByTitle(title: String): BaseFitnessItem? {
        // Concatenate all lists that hold BaseFitnessItem types
        val allItems = exercisesList + exerciseCategories // Add foodList and bodybuildersList when created
        return allItems.find { it.title == title }
    }

    /**
     * Retrieves a list of FitnessItems based on the specified category.
     * Used by ListActivity to populate the RecyclerView.
     */
    fun getListByCategory(category: String): List<BaseFitnessItem> {
        // If the category is the main screen (e.g., "Exercises"), return the sub-categories.
        if (category == "Exercises") { // Adjust "Exercises" to your main navigation title if different
            return exerciseCategories
        }

        // If the category matches a main group (e.g., "Chest", "Back"), return the detailed list of exercises.
        if (isExerciseCategory(category)) {
            return exercisesList.filter { it.category == category }
        }

        // Return empty list if no match is found
        return emptyList()
    }

    /**
     * Checks if the given title is one of the main exercise groups (e.g., "Chest", "Back").
     * Used by ListActivity to determine the next screen's data structure.
     */
    fun isExerciseCategory(title: String): Boolean {
        return exerciseCategories.any { it.title == title }
    }
} // <-- FINAL CLOSING BRACE for the FitnessData object.