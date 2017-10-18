package rocketstarter;
public class RocketStarter {

	public static void main(String[] args) {
        //initialize variables
        double emptyMass = 10000.0;
        double fuelMass = 10000.0;
        double payloadMass = 4704.0;
        double exhaustVelocity = 7000.0;
        double crossSection = 10.0;
        double dragCoefficient = 0.5;
        double rhoNaught = 1.225;
        double atmosphericMolarMass = 0.0289644;
        double idealGasConstant = 8.314;
        double radiusEarth = 6.371e6;
        double burnRate = 100.0;
        double g = 9.8;
        double G = 6.67e-11;
        double massEarth = 5.972e24;
        double temperature = 255.0;

        double time = 0.0;
        double y = 0.0;
        double v = 0.0;
        double a = 0.0;
        double deltaTime = 1.0e-3;

        // For Each Timestep
        while(v >= 0.0 && y <= 355000.0) {
            // Calculate acceleration
                double totalMass = fuelMass + emptyMass + payloadMass;
                // Calculate air density
                double rho = rhoNaught*Math.exp(-((g*atmosphericMolarMass*y)/
                                             (idealGasConstant*temperature)));
                // Calculate drag
                double drag = 0.5*rho*v*v*dragCoefficient*crossSection/
                              totalMass;

                // Calculate gravity
                double gravity = G*massEarth/(radiusEarth+y)/(radiusEarth+y);

                // If fuel remains, calculate thrust
                double thrust = 0.0;
                if(fuelMass>0.0) thrust = exhaustVelocity/totalMass*burnRate;

                // Acceleration = (thrust â€“ gravity â€“ drag)
                a = thrust - gravity - drag;

            // Calculate new velocity (v = v + a * dt)
            v += a*deltaTime;

            // Calculate new position (y = y + v * dt)
            y += v*deltaTime;

            // Calculate new fuel mass
            if(thrust>0.0)
                fuelMass -= burnRate*deltaTime;


            // calculate escape velocity
            double escapeVelocity = Math.sqrt(2*G*massEarth/(radiusEarth+y));

            // Output values at each timestep
            System.out.printf("%9.3f %9.3f %9.3f %9.3f %9.3f\n",time,y,
                            v,escapeVelocity,fuelMass);
            // update time
            time += deltaTime;
        }
    }
}