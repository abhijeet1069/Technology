<script src="script.js" defer></script>: The script is downloaded asynchronously but executed in order after the HTML parsing is complete, just before the DOMContentLoaded event.

<script src="script.js" async></script>: The script is downloaded and executed asynchronously without blocking the HTML parsing, as soon as it's downloaded, regardless of the order or the readiness of other resources.