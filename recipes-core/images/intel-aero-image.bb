DESCRIPTION = "Fully functional image for Intel Aero platform"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management ssh-server-openssh x11-base"

inherit core-image

IMAGE_INSTALL += "gstreamer1.0 gst-player \
				gstreamer1.0-vaapi libva va-intel libva-intel-driver \
				gstreamer1.0-plugins-base gstreamer1.0-plugins-good \
				gstreamer1.0-plugins-bad \
				gstreamer1.0-meta-base gstreamer1.0-rtsp-server \
				jam-stapl \
				px4-fw \
				camera-streaming-daemon \
				"

IMAGE_INSTALL += "mavlink-router"

# Allow to easily copy files to/from host
IMAGE_INSTALL += "rsync"

# Add /etc/os-release
IMAGE_INSTALL += "os-release"

IMAGE_INSTALL += "openssh-sftp-server"

# increase entropy right after boot so hostapd succeeds authentication
IMAGE_INSTALL += "rng-tools"

# Build tools
IMAGE_INSTALL += "packagegroup-core-buildessential"
IMAGE_INSTALL += "catkin"

# Development/Debug tools
IMAGE_INSTALL += "valgrind"

# Tests applications
IMAGE_INSTALL += "packagegroup-core-tools"

# AirMap
IMAGE_INSTALL += "packagegroup-airmap"

# OpenCV
IMAGE_INSTALL += "opencv"

# Dronekit
IMAGE_INSTALL += "dronekit-python"

# MavROS won't build with pyro
# IMAGE_INSTALL += "mavros"
IMAGE_INSTALL += "realsense-camera"

# Enable ros comm packagegroup
IMAGE_INSTALL += "packagegroup-ros-comm"

# PX4
IMAGE_INSTALL += "packagegroup-px4"

# librealsense
IMAGE_INSTALL += "librealsense"
IMAGE_INSTALL += "librealsense-graphical-examples"

#connectivity
IMAGE_INSTALL += "hostapd"
IMAGE_INSTALL += "autostart-hostapd"
IMAGE_INSTALL += "autostart-supplicant"

# LTE MODEM.
# Removed autostart-modem as it has install conflicts with networkmanager
IMAGE_INSTALL += "glibc-gconvs glibc-utils glibc-gconv-iso8859-1 modemmanager \
	rpm icon-naming-utils libtool libndp libnl libinput \
	libxdmcp networkmanager modem-enable \
"

addtask create_link after do_rootfs before do_image

do_create_link() {
	ln -s lib ${WORKDIR}/rootfs/lib64
}
