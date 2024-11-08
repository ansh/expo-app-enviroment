const getCurrentEnvironment = () => {
  if (typeof window !== "undefined") {
    // Check if running on localhost
    if (window.location.hostname === "localhost" || window.location.hostname === "127.0.0.1") {
      return "simulator";
    }

    // Check if running on HTTPS
    if (window.location.protocol === "https:") {
      return "appstore";
    }
  }

  // Default to appstore for any other case
  return "appstore";
};

export default {
  environment: getCurrentEnvironment(),
  getEnvironment: getCurrentEnvironment,
};
