% Code using preexisting functions:
% clear;
% sixty = [1/8, 1/8, 1/8, 1/8, 1/8, 1/8, 1/8, 1/8];
% eighty = [1/6, 1/6, 1/6, 1/6, 1/6, 1/6];
% h = conv(sixty, eighty);
% freqz(h);

clear;
figure_num = 1;

% Define the frequency of the sample rate in Hz 
sampleRate = 480;

% Define f as a vector from 0 Hz to one-half the sample rate
f = linspace(0,sampleRate/2,sampleRate);

% Convert linear frequency to angular frequency
% omega, units = radians/second
w = 2*pi*f;

% Convert angular frequency to Discrete Frequency
Omega = w / sampleRate;

% Define the term s, where real term (sigma) equals 0
% 1j is used for performance in MATLABhz +
s = 1j*Omega;

% Declare and Initialize transfer functions to output of h()
% The parameters for the function are the frequency of the desired null,
% the sample rate, and the term s
% Transfer functions are in the z-domain
h1 = h(60,sampleRate,s);
h2 = h(80,sampleRate,s);

% Multiply the transfer functions in the z-domain to create a single
% transfer function for the FIR Filter
H = h1 .* h2;

% Plot the magnitude response of the FIR Filter in dB versus
% Discrete Frequency
figure(figure_num); figure_num = figure_num + 1;
plot(Omega/pi,20*log10(abs(H)));
hold on

hold off
xlabel('Discrete Frequency, Omega/pi (Radians/Sample)')
ylabel('Magnitude (dB)')
xlim([0 1])
ylim([-100 2])
grid on

% Function defining z^n, used to create individual transfer functions
function z = z(s,n)
    z = exp(-s*n);
end

% Function used to create an individual transfer function with nulls
% at multiples of a specific frequency, given the sample rate
function h = h(freq,rate,s)
    h = 0;
    for a = 1:rate/freq
        h = h + freq/rate*z(s,a);
    end
end