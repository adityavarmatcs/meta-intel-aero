# Placeholder until https://patchwork.openembedded.org/patch/139701/ is merged
do_install_append() {
    if [ -e ${D}${bindir}/nosetests ]; then
        mv ${D}${bindir}/nosetests ${D}${bindir}/nosetests3
    fi
}

